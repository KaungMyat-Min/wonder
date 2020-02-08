package com.kaungmyatmin.wonder.models

import com.google.gson.annotations.SerializedName

data class Wonder(
    @SerializedName("location")
    var location: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("image")
    var image: String,

    @SerializedName("lat")
    var lat: Double,

    @SerializedName("long")
    var long: Double
)