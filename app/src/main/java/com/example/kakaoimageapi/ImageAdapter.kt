package com.example.kakaoimageapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kakaoimageapi.data.documents
import com.example.kakaoimageapi.databinding.ActivityMainBinding
import com.example.kakaoimageapi.databinding.AdapterBinding
import java.time.format.DateTimeFormatter


class ImageAdapter(private val context: Context, private val items: MutableList<documents>) : RecyclerView.Adapter<ImageAdapter.Holder>() {


    interface ItemClick {
        fun onClick(view : View, position : Int)
    }

    interface ItemLongClick {
        fun onLongClick(view : View, position : Int)
    }

    var itemClick : ItemClick? = null
    var itemLongClick : ItemLongClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = AdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {


        holder.itemView.setOnClickListener { //클릭이벤트추가부분
            itemClick?.onClick(it, position)
        }

        holder.itemView.setOnLongClickListener() OnLongClickListener@{
            itemLongClick?.onLongClick(it, position)
            return@OnLongClickListener true
        }

        val image = items[position].thumbnail_url
        Glide.with(context).load(image).into(holder.holderImageView)

        holder.holderSourceTextView.text = items[position].display_sitename
        holder.holderDateTextView.text = items[position].datetime

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Holder(binding: AdapterBinding) : RecyclerView.ViewHolder(binding.root) {

        val holderImageView = binding.adapterImageView
        val holderSourceTextView = binding.adapterSourceTextView
        val holderDateTextView = binding.adapterDateTextView


    }
}