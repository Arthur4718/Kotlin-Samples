package com.devarthur4718.flick

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

//Created by Arthur Gomes - 2018-23-02

class MainActivity : AppCompatActivity() {
    private val TAG = "mainactivity"
    private val URL = "https://api.flickr.com/services/feeds/photos_public.gne?tags=android,oreo&format=json&nojsoncallback=1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate called");

        val getRawData = GetRawData()
        getRawData.execute(URL)

    }
//    companion object {
//        //A similar solution to using static values in Kotlin as we use in Java
//        private const val TAG = "MainActivity"
//    }

    fun onDownloadComplete(data : String, status : DonwloadStatus){
        if(status == DonwloadStatus.OK){
             Log.d(TAG, "onDownload Complete called, data is $data")
        }else{
            //download failed
            Log.d(TAG, "onDownload failed with status $status. Error message is: $data")
        }
    }
}
