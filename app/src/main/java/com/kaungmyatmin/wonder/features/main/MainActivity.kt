package com.kaungmyatmin.wonder.features.main

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaungmyatmin.wonder.R
import com.kaungmyatmin.wonder.bases.BaseActivity
import com.kaungmyatmin.wonder.di.Injectable
import com.kaungmyatmin.wonder.utli.ViewModelProviderFactory
import javax.inject.Inject

class MainActivity : BaseActivity(), MainDependencyProvider, Injectable {



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

    override fun expandAppBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}