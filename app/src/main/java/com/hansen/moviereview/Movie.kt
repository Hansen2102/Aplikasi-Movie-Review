package com.hansen.moviereview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class Movie(
    val name: String,
    val description: String,
    val photo: Int
): Parcelable
