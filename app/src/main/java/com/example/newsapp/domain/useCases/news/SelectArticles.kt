package com.example.newsapp.domain.useCases.news

import com.example.newsapp.data.local.NewsDAO
import com.example.newsapp.data.model.ArticleDTO
import com.example.newsapp.domain.repository.NewsRepo
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepo: NewsRepo
) {
    operator fun invoke(): Flow<List<ArticleDTO>> {
        return newsRepo.getArticles()
    }
}