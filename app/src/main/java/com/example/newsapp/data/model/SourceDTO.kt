package com.example.newsapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SourceDTO(
    val id: String,
    val name: String
): Parcelable