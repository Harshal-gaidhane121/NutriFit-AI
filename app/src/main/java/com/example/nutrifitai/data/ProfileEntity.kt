package com.example.nutrifitai.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.nutrifitai.Screens.Goal

@Entity(tableName = "profile")
data class ProfileEntity(
    @PrimaryKey val id: Int = 1, // Single profile with fixed ID for simplicity
    val weight: Float,
    val height: Float,
    val age: Int,
    val gender: String,
    val medicalHistory: String,
    val goal: Goal
)

class GoalConverter {
    @TypeConverter
    fun fromGoal(goal: Goal): String {
        return goal.name
    }

    @TypeConverter
    fun toGoal(name: String): Goal {
        return Goal.valueOf(name)
    }
}