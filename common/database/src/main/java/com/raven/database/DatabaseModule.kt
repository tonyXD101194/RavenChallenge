package com.raven.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
class DatabaseModule {
//
//    @Singleton
//    @Provides
//    fun provideRoomDatabase(@ApplicationContext context: Context): RoomDatabase {
//        return Room.databaseBuilder(context, RoomDatabase::class.java, "raven_database.db")
//            .build()
//    }
}