package com.example.core.domain.usecase

import com.example.core.domain.model.News
import com.example.core.domain.repository.INewsRepository

class NewsInteractor(private val newsRepository: INewsRepository): NewsUseCase {

    override fun getAllNews() = newsRepository.getAllNews()

    override fun getBookmarkNews() = newsRepository.getBookmarkNews()

    override fun setBookmarkNews(news: News, state: Boolean) = newsRepository.setBookmarkNews(news, state)
}