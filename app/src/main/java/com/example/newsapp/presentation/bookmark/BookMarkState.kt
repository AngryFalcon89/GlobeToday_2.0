package com.example.newsapp.presentation.bookmark

import com.example.newsapp.data.model.ArticleDTO

data class BookMarkState (
    val articles: List<ArticleDTO> = emptyList()
)