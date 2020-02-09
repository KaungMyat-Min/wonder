package com.kaungmyatmin.wonder.features.main.data.remote


import com.kaungmyatmin.wonder.features.main.models.responses.SchemaWonders
import io.reactivex.Observable
import retrofit2.http.GET

interface MainApiService {
    @GET("13g69v")
    fun getWonders(): Observable<SchemaWonders>
}