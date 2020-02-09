package com.kaungmyatmin.wonder.bases

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import com.kaungmyatmin.wonder.di.Injectable
import com.kaungmyatmin.wonder.di.HasViewModel



open abstract class BaseFragment : Fragment(),Injectable {

    lateinit var dependencyProvider: HasViewModel

    abstract fun bindView(view:View)
    abstract fun setObservers()

    override fun onAttach(context: Context) {
        super.onAttach(context)
          try{
            dependencyProvider = context as HasViewModel
        }catch(e: ClassCastException){

        }
    }
}