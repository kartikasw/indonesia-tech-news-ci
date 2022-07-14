package com.example.indonesianews.detail

import androidx.lifecycle.ViewModel
import com.example.core.domain.model.News
import com.example.core.domain.usecase.NewsUseCase

class DetailNewsViewModel(private val newsUseCase: NewsUseCase) : ViewModel() {
    fun setBookmarkNews(news: News, newStatus:Boolean) =
        newsUseCase.setBookmarkNews(news, newStatus)
}