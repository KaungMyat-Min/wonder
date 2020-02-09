package com.kaungmyatmin.wonder.repository

import com.kaungmyatmin.wonder.api.MainApiService
import com.kaungmyatmin.wonder.models.responses.SchemaWonders
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class WonderRepository
@Inject
constructor(var apiServe: MainApiService) {
    fun getWonders(): Single<SchemaWonders> {
        return apiServe.getWonders()
    }

}