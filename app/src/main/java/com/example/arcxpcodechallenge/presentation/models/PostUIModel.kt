package com.example.arcxpcodechallenge.presentation.models

import android.os.Parcel
import android.os.Parcelable

data class PostUIModel(
    val id: Int = -1,
    val title: String = "",
    val content: String = "",
    val date: String = "",
    val rawDate: String = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(content)
        parcel.writeString(date)
        parcel.writeString(rawDate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PostUIModel> {
        override fun createFromParcel(parcel: Parcel): PostUIModel {
            return PostUIModel(parcel)
        }

        override fun newArray(size: Int): Array<PostUIModel?> {
            return arrayOfNulls(size)
        }
    }
}