package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    var newsId: String,
    var author: String?,
    var title: String?,
    var description: String?,
    var url: String,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?,
    var isBookmark: Boolean = false
) : Parcelable