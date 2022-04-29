package com.example.mvp_new.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvp_new.Model.GetDataBeritaResponseItem
import com.example.mvp_new.R
import kotlinx.android.synthetic.main.item_berita.view.*

class AdapterBerita(private var datanews : List<GetDataBeritaResponseItem>): RecyclerView.Adapter<AdapterBerita.ViewHolder>() {

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val result = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return ViewHolder(result)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvtitle.text = datanews!![position].title
        holder.itemView.tvcreated.text = datanews!![position].createdAt
        holder.itemView.tvaotor.text = datanews!![position].author

        Glide.with(holder.itemView.context)
            .load(datanews!![position].image)
            .into(holder.itemView.img_view)
    }

    override fun getItemCount(): Int {
        return datanews.size
    }
}