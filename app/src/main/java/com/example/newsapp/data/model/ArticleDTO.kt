package com.example.newsapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity("Article")
data class ArticleDTO(
    val author: String?,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceDTO,
    val title: String,
    @PrimaryKey val url: String,
    val urlToImage: String
): Parcelable