package com.devarthur4718.recyclerviewsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val kotlinItems : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Load List
        addListItens()

        //Create vertical layout manager
        rvMyList.layoutManager = LinearLayoutManager(this)

        //Access the recycler view adapter and load the data into it
         rvMyList.adapter = CardViewAdapter(kotlinItems, this)
    }

    private fun addListItens() {

        //Introduction
        kotlinItems.add("Hello Word")
        kotlinItems.add("Funcitons")
        kotlinItems.add("Variables")
        kotlinItems.add("Null Safety")
        kotlinItems.add("Generic")
        kotlinItems.add("Inheritance")

    }
}
