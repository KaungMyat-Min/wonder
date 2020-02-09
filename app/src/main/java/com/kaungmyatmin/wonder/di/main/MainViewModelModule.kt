package com.kaungmyatmin.wonder.di.main

import androidx.lifecycle.ViewModel
import com.kaungmyatmin.wonder.di.ViewModelKey
import com.kaungmyatmin.wonder.features.main.MainViewModel
import com.kaungmyatmin.wonder.features.wonderlist.WonderListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WonderListViewModel::class)
    abstract fun bindWonderListViewModel(wonderListViewModel: WonderListViewModel): ViewModel
}








