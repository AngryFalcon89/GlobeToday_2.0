package com.example.newsapp.domain.useCases.news


import androidx.paging.PagingData
import com.example.newsapp.data.model.ArticleDTO
import com.example.newsapp.domain.repository.NewsRepo
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepo: NewsRepo
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<ArticleDTO>>{
        return newsRepo.getNews(sources = sources)
    }
}