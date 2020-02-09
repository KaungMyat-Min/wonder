package com.kaungmyatmin.wonder.features.main.models.responses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.kaungmyatmin.wonder.features.main.models.Wonder

 class SchemaWonders{
     @SerializedName("wonders")
     @Expose
     var wonders: List<Wonder>? = null

 }