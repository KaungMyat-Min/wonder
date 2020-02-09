package com.kaungmyatmin.wonder.bases

import android.content.Context
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.kaungmyatmin.wonder.di.Injectable
import com.kaungmyatmin.wonder.features.main.MainDependencyProvider



open abstract class BaseFragment : Fragment(),Injectable {

    lateinit var dependencyProvider: MainDependencyProvider

    abstract fun bindView(view:View)
    abstract fun setObservers()

    override fun onAttach(context: Context) {
        super.onAttach(context)
          try{
            dependencyProvider = context as MainDependencyProvider
        }catch(e: ClassCastException){

        }
    }
}