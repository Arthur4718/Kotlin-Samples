package com.devarthur4718.kotlinsamples.Adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devarthur4718.kotlinsamples.DataModel.PartData
import com.devarthur4718.kotlinsamples.R
import com.devarthur4718.kotlinsamples.Views.ItemDetail
import kotlinx.android.synthetic.main.recycler_list_item.view.*

//* Created by Arthur Gomes at 04/03/19 15:57 - contact me at devarthur4718@gmail.com.br

class PartAdapter(val partItemList: List<PartData>, val clickListener: (PartData) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        // LayoutInflater: takes ID from layout defined in XML.
        // Instantiates the layout XML into corresponding View objects.
        // Use context from main app -> also supplies theme layout values!
        val inflater = LayoutInflater.from(parent.context)
        // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
        val view = inflater.inflate(R.layout.recycler_list_item, parent, false)
        return PartViewHolder(view)
    }

    override fun getItemCount() = partItemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as PartViewHolder).bind(partItemList[position])
    }

}

class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(part: PartData) {
        itemView.tv_item_data.text = part.itemName

        itemView.cardItem.setOnClickListener(View.OnClickListener {

            val intent = Intent(itemView.context, ItemDetail::class.java)

            itemView.context.startActivity(intent)
        })
    }
}