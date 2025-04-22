package com.example.nutrifitai.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Insert
    suspend fun insertProfile(profile: ProfileEntity)

    @Query("SELECT * FROM profile WHERE id = :id")
    fun getProfile(id: Int): Flow<ProfileEntity?>
}