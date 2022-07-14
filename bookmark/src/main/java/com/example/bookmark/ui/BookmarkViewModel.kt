package com.example.bookmark.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.NewsUseCase

class BookmarkViewModel(newsUseCase: NewsUseCase) : ViewModel() {
    val bookmarkNews = newsUseCase.getBookmarkNews().asLiveData()
}