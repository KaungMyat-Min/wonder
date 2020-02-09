package com.kaungmyatmin.wonder.features.wonderlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaungmyatmin.wonder.R
import com.kaungmyatmin.wonder.bases.BaseFragment
import com.kaungmyatmin.wonder.features.main.WonderAdapter
import javax.inject.Inject

class WonderListFragment : BaseFragment() {

    private lateinit var rvAdapter:WonderAdapter
    private lateinit var rvWonders: RecyclerView

    @Inject
    lateinit var wonderListViewModel: WonderListViewModel

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
        rvAdapter = WonderAdapter()
        rvWonders.adapter = rvAdapter
        setObservers()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wonderListViewModel.getWonders()
    }

    override fun bindView(view: View) {
        rvWonders = view.findViewById(R.id.rv_wonders)
    }

    override fun setObservers() {
        wonderListViewModel.wonders.observe(this, Observer {
            rvAdapter.wonders = it
        })

    }
}