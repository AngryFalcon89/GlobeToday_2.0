package com.example.newsapp.presentation.details

import com.example.newsapp.data.model.ArticleDTO

sealed class DetailEvent {
    data class UpsertDeleteArticle(val article: ArticleDTO): DetailEvent()

    object RemoveSideEffect: DetailEvent()
}