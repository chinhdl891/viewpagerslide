package com.example.pading3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pading3.databinding.ItemImageBinding

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    inner class ImageViewHolder(var itemImageBinding: ItemImageBinding) :
        RecyclerView.ViewHolder(itemImageBinding.root) {
        fun bind(intSrc: Int) {
            itemImageBinding.imageItem.setImageResource(intSrc)
        }
    }

    val listData = arrayListOf<Int>()

    fun setData(newList: List<Int>) {
        listData.clear()
        listData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val itemImageBinding =
            ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(itemImageBinding)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(listData[position])
    }
}