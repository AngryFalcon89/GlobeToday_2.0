package com.example.newsapp.domain.di

import android.app.Application
import androidx.room.Room
import com.example.newsapp.data.local.NewsDAO
import com.example.newsapp.data.local.NewsDatabase
import com.example.newsapp.data.local.NewsTypeConvertor
import com.example.newsapp.data.manager.LocalUserManagerImpl
import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.repository.NewsRepoImple
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsapp.domain.repository.NewsRepo
import com.example.newsapp.domain.useCases.appEntry.AppEntryUseCases
import com.example.newsapp.domain.useCases.appEntry.ReadAppEntry
import com.example.newsapp.domain.useCases.appEntry.SaveAppEntry
import com.example.newsapp.domain.useCases.news.DeleteArticleUseCase
import com.example.newsapp.domain.useCases.news.GetNews
import com.example.newsapp.domain.useCases.news.NewsUseCases
import com.example.newsapp.domain.useCases.news.SearchNews
import com.example.newsapp.domain.useCases.news.SelectArticle
import com.example.newsapp.domain.useCases.news.SelectArticles
import com.example.newsapp.domain.useCases.news.UpsertUseCase
import com.example.newsapp.utils.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object domainModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: ApiService,
        newsDAO: NewsDAO
    ): NewsRepo {
        return NewsRepoImple(newsApi, newsDAO)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepo,
        newsDAO: NewsDAO
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            deleteArticle = DeleteArticleUseCase(newsRepository),
            upsertArticles = UpsertUseCase(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDAO = newsDatabase.newsDao

}