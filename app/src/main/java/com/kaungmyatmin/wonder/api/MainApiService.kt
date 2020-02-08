package com.kaungmyatmin.wonder.api

import android.database.Observable
import com.kaungmyatmin.wonder.models.responses.SchemaWonders
import retrofit2.http.GET

interface MainApiService {
    @GET("/13g69v")
    fun getWonders(): Observable<SchemaWonders>
}