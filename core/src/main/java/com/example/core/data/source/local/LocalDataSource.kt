package com.example.core.data.source.local

import android.util.Log
import com.example.core.data.source.local.entity.NewsEntity
import com.example.core.data.source.local.room.NewsDao
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.Executors

class LocalDataSource constructor(private val newsDao: NewsDao) {

    fun getAllNews(): Flow<List<NewsEntity>> = newsDao.getAllNews()

    fun getBookmarkNews(): Flow<List<NewsEntity>> = newsDao.getBookmarkNews()

    fun insertNews(newsList: List<NewsEntity>) =
        Executors.newSingleThreadExecutor().execute {
            newsDao.insertNews(newsList)
        }

    fun setBookmarkNews(news: NewsEntity, newState: Boolean) {
        news.isBookmark = newState
        newsDao.updateBookmarkNews(news)
        Log.d(TAG, "Bookmark updated, $newState")
    }

    companion object {
        const val TAG = "LocalDataSource"
    }
}