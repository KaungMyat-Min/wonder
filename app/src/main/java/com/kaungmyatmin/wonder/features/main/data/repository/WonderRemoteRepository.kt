package com.kaungmyatmin.wonder.features.main.data.repository

import com.kaungmyatmin.wonder.features.main.data.remote.MainApiService
import com.kaungmyatmin.wonder.features.main.models.responses.SchemaWonders
import io.reactivex.Observable
import javax.inject.Inject

class WonderRemoteRepository
@Inject
constructor(var apiServe: MainApiService) {
    fun getLatestWonders(): Observable<SchemaWonders> {
        return apiServe.getWonders()
    }


}