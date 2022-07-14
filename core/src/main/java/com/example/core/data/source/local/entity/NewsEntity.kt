package com.example.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "newsId")
    var newsId: String,

    @ColumnInfo(name = "author")
    var author: String?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "description")
    var description: String?,

    @ColumnInfo(name = "content")
    var content: String?,

    @ColumnInfo(name = "url")
    var url: String,

    @ColumnInfo(name = "urlToImage")
    var urlToImage: String?,

    @ColumnInfo(name = "publishedAt")
    var publishedAt: String?,

    @ColumnInfo(name = "isBookmark")
    var isBookmark: Boolean = false
)