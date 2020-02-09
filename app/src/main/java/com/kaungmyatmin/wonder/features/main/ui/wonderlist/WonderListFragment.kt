package com.kaungmyatmin.wonder.features.main.ui.wonderlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaungmyatmin.wonder.R
import com.kaungmyatmin.wonder.bases.BaseFragment
import javax.inject.Inject

class WonderListFragment : BaseFragment() {


    private lateinit var rvWonders: RecyclerView

    lateinit var wonderListViewModel: WonderListViewModel

    @Inject
    lateinit var rvAdapter: WonderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        wonderListViewModel = activity?.run {
            ViewModelProvider(
                this,
                dependencyProvider.getVMProviderFactory()
            ).get(WonderListViewModel::class.java)
        }?: throw Exception("Invalid Activity")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_wonder_list, container, false)
        bindView(view)
        rvWonders.layoutManager = LinearLayoutManager(context)
        rvWonders.adapter = rvAdapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setObservers()
    }

    override fun bindView(view: View) {
        rvWonders = view.findViewById(R.id.rv_wonders)
    }

    override fun setObservers() {
        wonderListViewModel.wonders.observe(viewLifecycleOwner, Observer {
            Log.d("wonderlist","observing")
            rvAdapter.wonders = it
        })

    }
}