package com.example.newsapp.data.di

import android.app.Application
import com.example.newsapp.data.manager.LocalUserManagerImpl
import com.example.newsapp.data.network.ApiService
import com.example.newsapp.domain.manager.LocalUserManager
import com.example.newsapp.domain.useCases.appEntry.AppEntryUseCases
import com.example.newsapp.domain.useCases.appEntry.ReadAppEntry
import com.example.newsapp.domain.useCases.appEntry.SaveAppEntry
import com.example.newsapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object dataModule {

    @Provides
    @Singleton
    fun provideApiInstance(): ApiService {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}