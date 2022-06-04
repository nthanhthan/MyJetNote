package com.example.myjetnote.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myjetnote.model.ToDo
import com.example.myjetnote.utils.DateConverter


@Database(entities = [ToDo::class], version = 2, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDAO
}