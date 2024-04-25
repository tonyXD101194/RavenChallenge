package com.raven.home.presentation.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raven.core.utils.NetworkUtil
import com.raven.home.domain.usecases.DeleteArticleUseCase
import com.raven.home.domain.usecases.GeArticlesUseCase
import com.raven.home.domain.usecases.GeNewsUseCase
import com.raven.home.domain.usecases.SetArticleUseCase
import com.raven.models.model.NewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val geNewsUseCase: GeNewsUseCase,
    private val geArticlesUseCase: GeArticlesUseCase,
    private val setArticleUseCase: SetArticleUseCase,
    private val deleteArticleUseCase: DeleteArticleUseCase,
    @SuppressLint("StaticFieldLeak") @ApplicationContext val context: Context
) : ViewModel() {

    init {
        getNews()
    }

    private val _news: MutableLiveData<List<NewModel>> = MutableLiveData()
    val news: LiveData<List<NewModel>> get() = _news

    fun getNews(period: Int = 1) = viewModelScope.launch(Dispatchers.IO) {

        if (NetworkUtil(context).hasInternetConnection()) {
            geNewsUseCase.execute(period).collect { news ->
                _news.postValue(news)
                insertNews(period, news)
            }
        } else {
            geArticlesUseCase.execute(period).collect { news ->
                _news.postValue(news)
            }
        }
    }

    private fun insertNews(period: Int, news: List<NewModel>) = viewModelScope.launch(Dispatchers.IO) {
        deleteArticleUseCase.execute(period)
        news.forEach { model ->
            setArticleUseCase.execute(model)
        }
    }
}
