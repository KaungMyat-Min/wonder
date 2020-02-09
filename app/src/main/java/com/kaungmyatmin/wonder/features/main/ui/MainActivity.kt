package com.kaungmyatmin.wonder.features.main.ui

import android.os.Bundle
import com.kaungmyatmin.wonder.R
import com.kaungmyatmin.wonder.bases.BaseActivity
import com.kaungmyatmin.wonder.di.Injectable
import com.kaungmyatmin.wonder.di.HasViewModel
import com.kaungmyatmin.wonder.utli.ViewModelProviderFactory
import javax.inject.Inject

class MainActivity : BaseActivity(),
    HasViewModel, Injectable {



    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    override fun getVMProviderFactory() = providerFactory


    override fun displayProgressBar(bool: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}