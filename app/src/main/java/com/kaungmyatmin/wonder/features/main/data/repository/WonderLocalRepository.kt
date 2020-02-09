package com.kaungmyatmin.wonder.features.main.data.repository


import com.kaungmyatmin.wonder.features.main.data.local.WonderDao
import com.kaungmyatmin.wonder.features.main.models.Wonder
import io.reactivex.Observable
import javax.inject.Inject


class WonderLocalRepository @Inject constructor(val wonderDao: WonderDao) {
    fun getCachedWonder(): Observable<List<Wonder>> {
        return wonderDao.getAll()
    }

    suspend fun insertAll(wonders: List<Wonder>) {
        wonderDao.insertAll(wonders)
    }

    suspend fun updateOrDelete() {
        //todo: implement deleting only unwanted one by implementing equal() on Word Model
        wonderDao.deleteAll()
    }
}