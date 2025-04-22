package com.example.nutrifitai.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ProfileEntity::class], version = 1, exportSchema = false)
@TypeConverters(GoalConverter::class)
abstract class NutriFitDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
}