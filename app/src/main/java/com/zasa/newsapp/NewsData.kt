package com.zasa.newsapp

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)