package com.kaungmyatmin.wonder.features.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kaungmyatmin.wonder.R
import com.kaungmyatmin.wonder.models.Wonder
import com.kaungmyatmin.wonder.utli.loadImage
import javax.inject.Inject

class WonderAdapter constructor() : RecyclerView.Adapter<WonderAdapter.MyViewHolder>() {
    var wonders: List<Wonder>? = null
        set(value) {
            field = value
            notifyDataSetChanged()

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context);
        val view = inflater.inflate(R.layout.item_wonder, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = wonders?.size ?: 0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(wonders?.get(position))
    }

    class MyViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val tvAnimalType = view.findViewById<TextView>(R.id.tv_wonder_title)
        val ivPhoto = view.findViewById<ImageView>(R.id.iv_photo)

        fun bindData(wonder: Wonder?){

            wonder?.let {
                tvAnimalType?.text = it.description
                 loadImage(wonder.image,ivPhoto)

            }

        }
    }
}