package com.zasa.newsapp

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.security.Key

/**
 **@Project -> NewsApp
 **@Author -> Sangeeth on 9/15/2022
 */
interface NewsApi {

    @GET("top-headlines")
    fun getNews(
        @Query("apiKey") apiKey : String,
        @Query("country") country : String
    ) : Call<NewsData>

}