package com.kaungmyatmin.wonder.utli

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun loadImage(url:String,imageView: ImageView?){
    imageView?.let {  Picasso.get().load(url).into(it)}

}