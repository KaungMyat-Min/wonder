package com.kaungmyatmin.wonder.api


import com.kaungmyatmin.wonder.models.responses.SchemaWonders
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface MainApiService {
    @GET("13g69v")
    fun getWonders(): Single<SchemaWonders>
}