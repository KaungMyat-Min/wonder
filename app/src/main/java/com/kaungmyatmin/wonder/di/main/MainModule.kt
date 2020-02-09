package com.kaungmyatmin.wonder.di.main

import com.kaungmyatmin.wonder.features.main.data.remote.MainApiService
import com.kaungmyatmin.wonder.features.main.ui.MainActivity
import com.kaungmyatmin.wonder.features.main.data.local.AppDatabase
import com.kaungmyatmin.wonder.features.main.data.local.WonderDao
import com.kaungmyatmin.wonder.utli.NavigationHelper
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

    @MainScope
    @Provides
    fun provideNavigationHelper(activity: MainActivity):NavigationHelper {
        return NavigationHelper(activity)
    }



}

















