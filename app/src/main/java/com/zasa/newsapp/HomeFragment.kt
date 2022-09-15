package com.zasa.newsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.zasa.newsapp.Utils.API_KEY
import com.zasa.newsapp.Utils.BASE_URL
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "HomeFragment"

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val newsList = mutableListOf<Article>()
        val breakingNewsAdapter = BreakingNewsAdapter(requireContext().applicationContext, newsList)

        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        val retrofitService = retrofit.create(NewsApi::class.java)

        retrofitService.getNews("$API_KEY", "us").enqueue(object : Callback<NewsData> {
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                val body = response.body()
                Log.i(TAG, "response : $body")
                rvLatest.adapter = breakingNewsAdapter
                rvLatest.layoutManager = LinearLayoutManager(requireContext().applicationContext, LinearLayoutManager.HORIZONTAL, false)
                newsList.addAll(body!!.articles)
                breakingNewsAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Log.i(TAG, "failure : $t")
            }

        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}