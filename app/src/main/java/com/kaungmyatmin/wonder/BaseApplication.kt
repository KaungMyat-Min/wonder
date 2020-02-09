package com.kaungmyatmin.wonder

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import com.kaungmyatmin.wonder.di.application.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class BaseApplication : Application(), HasActivityInjector{

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        Stetho.initializeWithDefaults(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector;
}