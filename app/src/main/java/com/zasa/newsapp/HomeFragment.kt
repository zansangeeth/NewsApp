package com.zasa.newsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SearchEvent
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.zasa.newsapp.Utils.API_KEY
import com.zasa.newsapp.Utils.BASE_URL
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.temporal.TemporalQuery

private const val TAG = "HomeFragment"

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val newsList = arrayListOf<Article>()
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
                rvLatest.layoutManager = LinearLayoutManager(
                    requireContext().applicationContext,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                newsList.addAll(body!!.articles)
                breakingNewsAdapter.notifyDataSetChanged()

                breakingNewsAdapter.setOnItemClickListener(object :
                    BreakingNewsAdapter.onItemClickListner {
                    override fun onItemClick(position: Int) {
                        Toast.makeText(
                            requireContext().applicationContext,
                            "item clicked $position",
                            Toast.LENGTH_SHORT
                        ).show()


                        val singleNewsActivityIntent = Intent(requireContext().applicationContext, SingleNewsActivity::class.java)

                        singleNewsActivityIntent.putExtra("image", newsList[position].urlToImage)
                        singleNewsActivityIntent.putExtra("time", newsList[position].publishedAt)
                        singleNewsActivityIntent.putExtra("title", newsList[position].title)
                        singleNewsActivityIntent.putExtra("author", newsList[position].author)
                        singleNewsActivityIntent.putExtra("description", newsList[position].description)

                        startActivity(singleNewsActivityIntent)
                    }

                })

            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Log.i(TAG, "failure : $t")
            }

        })

        //top news in linear layout
        retrofitService.getSearchNews("us", "$API_KEY").enqueue(object : Callback<NewsData>{
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                val body = response.body()
                Log.i(TAG, "search response : $body")
                rvSearchNews.adapter = breakingNewsAdapter
                rvSearchNews.layoutManager = LinearLayoutManager(requireContext().applicationContext)
            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Log.i(TAG, "failure $t")
            }

        })

        //search results
//        svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                var searchResultsIntent = Intent(requireContext().applicationContext, SearchResultsActivity::class.java)
//                searchResultsIntent.putExtra("query", query)
//                startActivity(searchResultsIntent)
//                return false
//            }
//
//            override fun onQueryTextChange(query: String?): Boolean {
//                return false
//            }
//
//        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}