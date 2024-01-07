package com.example.newsapp.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapp.data.model.ArticleDTO

class SearchNewsPagingSource(
    private val newsApi: ApiService,
    private val searchQuery : String,
    private val sources : String
) : PagingSource<Int, ArticleDTO>() {
    private var totalNewsCount = 0

    override fun getRefreshKey(state: PagingState<Int, ArticleDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleDTO> {
        val page = params.key ?:1
        return try {
            val newsResponse = newsApi.searchNews(searchQuery = searchQuery,page = page, sources = sources)
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title } //news with same titles are removed

            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        }catch (e: Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}