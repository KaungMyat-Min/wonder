package com.kaungmyatmin.wonder.repository


import com.kaungmyatmin.wonder.local.WonderDao
import com.kaungmyatmin.wonder.models.Wonder
import io.reactivex.Flowable
import io.reactivex.Observable
import org.intellij.lang.annotations.Flow
import javax.inject.Inject


class WonderLocalRepository @Inject constructor(val wonderDao: WonderDao) {
    fun getCachedWonder(): Observable<List<Wonder>> {
        return wonderDao.getAll()
    }

    suspend fun insertAll(wonders: List<Wonder>) {
        wonderDao.insertAll(wonders)
    }

    suspend fun deleteAll() {
        wonderDao.deleteAll()
    }
}