package com.kaungmyatmin.wonder.di.main


import com.kaungmyatmin.wonder.features.main.ui.detail.WonderDetailFragment
import com.kaungmyatmin.wonder.features.main.ui.wonderlist.WonderListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun contributeWonderListFragment(): WonderListFragment

    @ContributesAndroidInjector()
    abstract fun contributeWonderDetailFragment(): WonderDetailFragment
}