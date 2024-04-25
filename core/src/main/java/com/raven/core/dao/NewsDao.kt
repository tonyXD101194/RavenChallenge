package com.raven.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.raven.models.entity.NewEntity

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(news: NewEntity)

    @Query("SELECT * FROM news WHERE id = :id")
    fun getNewById(id: Int): NewEntity?

    @Query("SELECT * FROM news WHERE period = :period")
    fun getNews(period: Int): List<NewEntity>?

    @Query("DELETE FROM news WHERE period = :period")
    fun deleteNews(period: Int)
}