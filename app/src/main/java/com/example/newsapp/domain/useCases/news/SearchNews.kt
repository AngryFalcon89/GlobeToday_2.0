package com.example.newsapp.domain.useCases.news

import androidx.paging.PagingData
import com.example.newsapp.data.model.ArticleDTO
import com.example.newsapp.domain.repository.NewsRepo
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepo
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<ArticleDTO>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}