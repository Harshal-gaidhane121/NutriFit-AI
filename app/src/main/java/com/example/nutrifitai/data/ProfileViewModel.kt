package com.example.nutrifitai.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nutrifitai.data.DailyTrackingEntity
import com.example.nutrifitai.data.ProfileRepository
import com.example.nutrifitai.data.ProfileData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.time.LocalDate

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {


    fun saveProfile(profileData: ProfileData) {
        viewModelScope.launch {
            repository.saveProfile(profileData)
        }
    }

    fun getProfile(): Flow<ProfileData?> {
        return repository.getProfile()
    }

//    fun saveDailyTracking(
//        profileId: Int,
//        calories: Float,
//        protein: Float,
//        water: Float,
//        carbs: Float,
//        fats: Float,
//        fiber: Float
//    ) {
//        viewModelScope.launch {
//            repository.saveDailyTracking(profileId, calories, protein, water, carbs, fats, fiber)
//        }
//    }
//
//    fun getDailyTracking(profileId: Int): Flow<DailyTrackingEntity?> {
//        return repository.getDailyTracking(profileId, LocalDate.now().toString())
//    }

}