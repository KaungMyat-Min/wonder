package com.kaungmyatmin.wonder.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "wonders"
)
data class Wonder(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = -1,

    @ColumnInfo(name = "location")
    @SerializedName("location")
    @Expose
    var location: String,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    @Expose
    var description: String,

    @ColumnInfo(name = "image")
    @SerializedName("image")
    @Expose
    var image: String,

    @ColumnInfo(name = "lat")
    @SerializedName("lat")
    @Expose
    var lat: Double,

    @ColumnInfo(name = "longi")
    @SerializedName("long")
    @Expose
    var longi: Double
):Parcelable