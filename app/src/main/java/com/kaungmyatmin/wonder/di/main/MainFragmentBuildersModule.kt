package com.kaungmyatmin.wonder.di.main


import com.kaungmyatmin.wonder.features.detail.WonderDetailFragment
import com.kaungmyatmin.wonder.features.wonderlist.WonderListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector()
    abstract fun contributeWonderListFragment(): WonderListFragment

    @ContributesAndroidInjector()
    abstract fun contributeWonderDetailFragment(): WonderDetailFragment
}