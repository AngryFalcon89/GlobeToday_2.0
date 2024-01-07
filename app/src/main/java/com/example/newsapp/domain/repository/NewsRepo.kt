package com.example.newsapp.domain.repository

import androidx.paging.PagingData
import com.example.newsapp.data.model.ArticleDTO
import kotlinx.coroutines.flow.Flow

interface NewsRepo {
    fun getNews(sources: List<String>): Flow<PagingData<ArticleDTO>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<ArticleDTO>>

    suspend fun upsertArticle(article: ArticleDTO)

    suspend fun deleteArticle(article: ArticleDTO)

    fun getArticles(): Flow<List<ArticleDTO>>

    suspend fun getArticle(url: String): ArticleDTO?
}