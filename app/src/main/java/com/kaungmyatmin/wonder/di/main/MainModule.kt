package com.kaungmyatmin.wonder.di.main

import com.kaungmyatmin.wonder.api.MainApiService
import com.kaungmyatmin.wonder.local.AppDatabase
import com.kaungmyatmin.wonder.local.WonderDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {

    @MainScope
    @Provides
    fun provideMainApiService(retrofitBuilder: Retrofit.Builder): MainApiService {
        return retrofitBuilder
            .build()
            .create(MainApiService::class.java)
    }

    @MainScope
    @Provides
    fun provideBlogPostDao(db: AppDatabase): WonderDao {
        return db.wonderDao()
    }


}

















