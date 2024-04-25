package com.raven.core.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raven.core.dao.NewsDao
import com.raven.models.entity.NewEntity

@Database(entities = [NewEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}