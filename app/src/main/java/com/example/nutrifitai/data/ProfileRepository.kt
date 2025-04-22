package com.example.nutrifitai.data

import com.example.nutrifitai.Screens.Goal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProfileRepository(private val profileDao: ProfileDao) {
    suspend fun saveProfile(profile: ProfileData) {
        profileDao.insertProfile(
            ProfileEntity(
                weight = profile.weight,
                height = profile.height,
                age = profile.age,
                gender = profile.gender,
                medicalHistory = profile.medicalHistory,
                goal = profile.goal
            )
        )
    }

    fun getProfile(): Flow<ProfileData?> {
        return profileDao.getProfile(1).map { entity ->
            entity?.let {
                ProfileData(
                    weight = it.weight,
                    height = it.height,
                    age = it.age,
                    gender = it.gender,
                    medicalHistory = it.medicalHistory,
                    goal = it.goal
                )
            }
        }
    }
}

// Reusing ProfileData from SetProfileScreen
data class ProfileData(
    val weight: Float,
    val height: Float,
    val age: Int,
    val gender: String,
    val medicalHistory: String,
    val goal: Goal
)