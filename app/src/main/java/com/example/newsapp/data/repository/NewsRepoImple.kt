package com.example.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapp.data.local.NewsDAO
import com.example.newsapp.data.model.ArticleDTO
import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.network.NewsPagingSource
import com.example.newsapp.data.network.SearchNewsPagingSource
import com.example.newsapp.domain.repository.NewsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class NewsRepoImple(
    private val newsApi : ApiService,
    private val newsDAO: NewsDAO
) : NewsRepo {
    override fun getNews(sources: List<String>): Flow<PagingData<ArticleDTO>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchNews(
        searchQuery: String,
        sources: List<String>
    ): Flow<PagingData<ArticleDTO>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
    override suspend fun upsertArticle(article: ArticleDTO) {
        newsDAO.upsert(article)
    }

    override suspend fun deleteArticle(article: ArticleDTO) {
        newsDAO.delete(article)
    }

    override fun getArticles(): Flow<List<ArticleDTO>> {
        return newsDAO.getArticle()
    }

    override suspend fun getArticle(url: String): ArticleDTO? {
        return newsDAO.getArticle(url = url)
    }
}