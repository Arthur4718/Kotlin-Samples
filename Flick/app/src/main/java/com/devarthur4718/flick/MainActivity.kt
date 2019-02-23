package com.devarthur4718.flick

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

//Created by Arthur Gomes - 2018-23-02

class MainActivity : AppCompatActivity() {
    private val TAG = "mainactivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate called");

    }
//    companion object {
//        //A similar solution to using static values in Kotlin as we use in Java
//        private const val TAG = "MainActivity"
//    }
}
