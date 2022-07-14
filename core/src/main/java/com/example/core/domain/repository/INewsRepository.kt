package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.News
import kotlinx.coroutines.flow.Flow

interface INewsRepository {

    fun getAllNews(): Flow<Resource<List<News>>>

    fun getBookmarkNews(): Flow<List<News>>

    fun setBookmarkNews(news: News, state: Boolean)

}