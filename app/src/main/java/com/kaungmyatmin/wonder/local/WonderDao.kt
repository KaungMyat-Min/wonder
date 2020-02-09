package com.kaungmyatmin.wonder.local

import androidx.annotation.UiThread
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kaungmyatmin.wonder.models.Wonder
import io.reactivex.Flowable
import io.reactivex.Observable


@Dao
interface WonderDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   fun insertAll(wonders:List<Wonder>)

    @Query("SELECT * FROM wonders")
    @UiThread
    fun getAll(): Observable<List<Wonder>>
}