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

class MainActivity : BaseActivity(),MainDependencyProvider,Injectable {
    override val TAG:String = "MainActivity"

    private lateinit var rvWonders: RecyclerView

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvWonders = findViewById(R.id.rv_wonders)
        rvWonders.layoutManager = LinearLayoutManager(this)
        val rvAdapter =WonderAdapter()
        rvWonders.adapter = rvAdapter

        mainViewModel.wonders.observe(this, Observer {
            rvAdapter.wonders = it
        })

        if(savedInstanceState == null){
            mainViewModel.getWonders()
        }

    }


    override fun getVMProviderFactory() = providerFactory


    override fun displayProgressBar(bool: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun expandAppBar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}