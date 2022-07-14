package com.example.core.data.source.remote.response

data class ListNewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NewsResponse>
)

data class NewsResponse (
    val source: SourceResponse,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)

data class SourceResponse(
    val id: String?,
    val name: String
)