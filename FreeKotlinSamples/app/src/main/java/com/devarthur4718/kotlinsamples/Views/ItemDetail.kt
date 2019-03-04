package com.devarthur4718.kotlinsamples.Views

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import com.devarthur4718.kotlinsamples.R

import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(toolbar)


    }

}
