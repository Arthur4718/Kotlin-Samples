package com.devarthur4718.recyclerviewsample

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.cell_item_kotlin.view.*


class CardViewAdapter(val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {



    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewGroup, p1: Int) {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.cell_item_kotlin, p0, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        holder?.tvTitulo?.text = items.get(position)
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val tvTitulo = view.tvSubTitle
}
