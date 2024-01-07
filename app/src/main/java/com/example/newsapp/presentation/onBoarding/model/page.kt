package com.example.newsapp.presentation.onBoarding.model

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    page(
        title = "Welcome to GlobeToday",
        description = "Discover the Latest News\n\nStay informed with the latest news from around the world. Our app provides up-to-date and relevant news articles to keep you in the know.",
        image = R.drawable.onboarding1
    ),
    page(
        title = "Effortless News Search",
        description = "Easily search for news topics that matter to you. Our powerful search feature allows you to find specific news articles and stay updated on your interests.",
        image = R.drawable.onboarding2
    ),
    page(
        title = "Bookmark Your Favorites",
        description = "Bookmark and save your favorite news articles for later. Our app lets you create a personalized reading list, making it convenient to revisit and share articles.",
        image = R.drawable.onboarding3
    )
)

