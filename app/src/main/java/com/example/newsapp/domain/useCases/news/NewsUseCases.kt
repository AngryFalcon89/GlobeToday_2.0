package com.example.newsapp.domain.useCases.news

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews: SearchNews,
    val upsertArticles: UpsertUseCase,
    val deleteArticle: DeleteArticleUseCase,
    val selectArticles: SelectArticles,
    val selectArticle: SelectArticle
)