package com.example.newsapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.data.model.ArticleDTO
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: ArticleDTO)

    @Delete
    suspend fun delete(article: ArticleDTO)

    @Query("SELECT * FROM article")
    fun getArticle(): Flow<List<ArticleDTO>>

    @Query("SELECT * FROM article WHERE url = :url")
    suspend fun getArticle(url: String): ArticleDTO?
}