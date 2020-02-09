package com.kaungmyatmin.wonder.features.main.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kaungmyatmin.wonder.features.main.models.Wonder
import io.reactivex.Observable


@Dao
interface WonderDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(wonders: List<Wonder>)

    @Query("SELECT * FROM wonders")
    fun getAll(): Observable<List<Wonder>>

    @Query("DELETE FROM wonders")
    suspend fun deleteAll()
}