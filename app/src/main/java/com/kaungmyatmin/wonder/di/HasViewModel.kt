package com.kaungmyatmin.wonder.di


import com.kaungmyatmin.wonder.utli.ViewModelProviderFactory

/**
 *
 * Have to do this to make the viewModel survive the config changes
 * never inject the view model directly, just inject the viewmodel factory
 */
interface HasViewModel{

    fun getVMProviderFactory(): ViewModelProviderFactory

}