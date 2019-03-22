package com.devarthur4718.kotlinsamples.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.devarthur4718.kotlinsamples.R


class ItemDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)


        initAction()
        setTheme(R.style.AppTheme)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun initAction() {


    }


}
