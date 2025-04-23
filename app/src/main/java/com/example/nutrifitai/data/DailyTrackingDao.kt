package com.example.nutrifitai.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyTrackingDao {
    @Insert
    suspend fun insertTracking(tracking: DailyTrackingEntity)

    @Query("SELECT * FROM daily_tracking WHERE profileId = :profileId AND date = :date")
    fun getTrackingForDate(profileId: Int, date: String): Flow<DailyTrackingEntity?>
}