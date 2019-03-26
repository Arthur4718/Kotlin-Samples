package com.devarthur4718.kotlinsamples.Views

import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.devarthur4718.kotlinsamples.R
import java.util.*


class ItemDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)



        setTheme(R.style.AppTheme)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        initAction()



    }

    private fun initAction() {

      


    }


}
