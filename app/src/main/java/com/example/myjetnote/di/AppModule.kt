package com.example.myjetnote.di

import android.content.Context
import androidx.room.Room
import com.example.myjetnote.datasource.AppDatabase
import com.example.myjetnote.datasource.TodoDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDb(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "todo.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideTodoDAO(db: AppDatabase): TodoDAO {
        return db.todoDao()
    }

}