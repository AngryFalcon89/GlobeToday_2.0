package com.example.newsapp.domain.useCases.news

import com.example.newsapp.data.local.NewsDAO
import com.example.newsapp.data.model.ArticleDTO
import com.example.newsapp.domain.repository.NewsRepo

class DeleteArticleUseCase(
    private val newsRepo: NewsRepo
) {
    suspend operator fun invoke(articleDTO: ArticleDTO){
        newsRepo.deleteArticle(articleDTO)
    }
}