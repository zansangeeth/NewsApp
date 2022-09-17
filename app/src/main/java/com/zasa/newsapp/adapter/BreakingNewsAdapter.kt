package com.zasa.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.zasa.newsapp.response.Article
import com.zasa.newsapp.R

/**
 **@Project -> NewsApp
 **@Author -> Sangeeth on 9/15/2022
 */
class BreakingNewsAdapter(val context: Context, val breakingNewsList: List<Article>) :
    RecyclerView.Adapter<BreakingNewsAdapter.ViewHolder>() {

    lateinit var mListener : onItemClickListner

    interface onItemClickListner{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListner){
        mListener = listener

    }

    inner class ViewHolder(itemView: View, listener: onItemClickListner) : RecyclerView.ViewHolder(itemView) {
        fun bind(breakingNews: Article) {
            itemView.findViewById<TextView>(R.id.tvUsername).text = breakingNews.author
            itemView.findViewById<TextView>(R.id.tvHeadline).text = breakingNews.title
            itemView.findViewById<TextView>(R.id.tvPublishedAt).text = breakingNews.publishedAt
            Glide.with(context).load(breakingNews.urlToImage).transform(CenterCrop(), RoundedCorners(20)).into(itemView.findViewById(
                R.id.ivBreakingNes
            ))
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_latest, parent, false), mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val breakingNews = breakingNewsList[position]
        holder.bind(breakingNews)
    }

    override fun getItemCount() = breakingNewsList.size
}