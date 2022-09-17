package com.zasa.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zasa.newsapp.response.FavouriteData
import com.zasa.newsapp.R
import kotlinx.android.synthetic.main.item_favourite.view.*

/**
 **@Project -> NewsApp
 **@Author -> Sangeeth on 9/16/2022
 */
class FavouriteAdapter(val context: Context, val favouriteList: List<FavouriteData>) :
    RecyclerView.Adapter<FavouriteAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(favouriteList: FavouriteData) {
            Glide.with(context).load(favouriteList.image).into(itemView.ivFavouriteImage)
            itemView.tvFavouriteHeadline.text = favouriteList.title
            itemView.tvFavouriteUpdatedTime.text = favouriteList.time
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_favourite, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favouriteList = favouriteList[position]
        holder.bind(favouriteList)
    }

    override fun getItemCount() = favouriteList.size
}