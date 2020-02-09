package com.kaungmyatmin.wonder.features.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kaungmyatmin.wonder.R
import com.kaungmyatmin.wonder.bases.BaseFragment
import com.kaungmyatmin.wonder.models.Wonder
import com.kaungmyatmin.wonder.utli.loadImage

class WonderDetailFragment : BaseFragment() {

    private lateinit var ivPhoto:ImageView
    private lateinit var tvDescrption:TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_wonder_detail,container,false)
        bindView(view)
        val args = arguments
        if (args != null) {
            val wonder  = args.getParcelable("wonder") as Wonder?
            wonder?.let {
                tvDescrption.text = wonder.description
                loadImage(wonder.image,ivPhoto)
            }
        }
        return view
    }

    override fun bindView(view: View) {
        ivPhoto = view.findViewById(R.id.iv_photo)
        tvDescrption = view.findViewById(R.id.tv_wonder_title)
    }

    override fun setObservers() {

    }
}