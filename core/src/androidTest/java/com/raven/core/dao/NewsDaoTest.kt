package com.raven.core.dao

import android.content.Context
import androidx.room.Room
import androidx.test.runner.AndroidJUnit4
import androidx.test.core.app.ApplicationProvider
import com.raven.core.rule.TestDatabaseWatcher
import com.raven.core.storage.AppDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class NewsDaoTest {

    private lateinit var newsDao: NewsDao
    private lateinit var db: AppDatabase

    @Before
    fun createDB() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        newsDao = db.newsDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDB() {
        db.close()
    }

    @Test
    @Throws(IOException::class)
    fun setNew() {
        val model = TestDatabaseWatcher.getModel()

        newsDao.insert(model)

        val news = newsDao.getNews(model.id)

        assert(news?.isNotEmpty() == true)
    }

    @Test
    @Throws(IOException::class)
    fun removeNew() {
        val model = TestDatabaseWatcher.getModel()

        newsDao.insert(model)
        newsDao.deleteNews(model.period)

        val news = newsDao.getNews(model.id)

        assert(news?.isEmpty() == true)
    }
}