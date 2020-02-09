package com.kaungmyatmin.wonder.utli

import android.app.Activity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.kaungmyatmin.wonder.R
import com.kaungmyatmin.wonder.features.main.models.Wonder

class NavigationHelper constructor(val activity: Activity) {
    fun toWonderDetail(wonder: Wonder) {
        val bundle = Bundle()
        bundle.putParcelable("wonder", wonder)
        getNavController()
            .navigate(R.id.dest_wonderDetailFragment, bundle)
    }

    private fun getNavController(): NavController {
        return Navigation.findNavController(activity, R.id.nav_host_fragment)
    }
}