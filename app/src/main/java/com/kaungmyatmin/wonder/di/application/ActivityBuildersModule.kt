package com.kaungmyatmin.wonder.di.application

import com.kaungmyatmin.wonder.di.main.MainFragmentBuildersModule
import com.kaungmyatmin.wonder.di.main.MainModule
import com.kaungmyatmin.wonder.di.main.MainScope
import com.kaungmyatmin.wonder.di.main.MainViewModelModule
import com.kaungmyatmin.wonder.features.main.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuildersModule {
    @MainScope
    @ContributesAndroidInjector(
        modules = [MainModule::class, MainFragmentBuildersModule::class, MainViewModelModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity

}