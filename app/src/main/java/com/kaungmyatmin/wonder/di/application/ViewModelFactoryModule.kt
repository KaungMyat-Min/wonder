package com.kaungmyatmin.wonder.di.application

import androidx.lifecycle.ViewModelProvider
import com.kaungmyatmin.wonder.utli.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}