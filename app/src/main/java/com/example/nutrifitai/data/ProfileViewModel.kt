package com.example.nutrifitai.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nutrifitai.data.ProfileRepository
import com.example.nutrifitai.data.ProfileData
import kotlinx.coroutines.launch

class ProfileViewModel(private val repository: ProfileRepository) : ViewModel() {
    fun saveProfile(profileData: ProfileData) {
        viewModelScope.launch {
            repository.saveProfile(profileData)
        }
    }
}