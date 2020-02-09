package com.kaungmyatmin.wonder.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WonderViewState (
    var viewBlogFields: ViewWonders = ViewWonders()
):Parcelable{
    @Parcelize
    data class ViewWonders(
        var blogPost: Wonder? = null
    ) : Parcelable
}