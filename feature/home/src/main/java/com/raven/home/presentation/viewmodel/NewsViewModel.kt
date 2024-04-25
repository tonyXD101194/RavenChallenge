package com.raven.home.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raven.home.domain.usecases.GeArticleUseCase
import com.raven.models.model.NewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val geArticleUseCase: GeArticleUseCase
): ViewModel() {

    private val _article: MutableLiveData<NewModel> = MutableLiveData()
    val article: LiveData<NewModel> get() = _article

    fun getNewModel(id: Long) = viewModelScope.launch(Dispatchers.IO) {
        geArticleUseCase.execute(id.toInt()).collect {
            it?.let { model ->
                _article.postValue(model)
            }
        }
    }
}