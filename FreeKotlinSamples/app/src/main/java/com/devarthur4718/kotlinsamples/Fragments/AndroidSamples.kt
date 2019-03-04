package com.devarthur4718.kotlinsamples.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.devarthur4718.kotlinsamples.R


//* Created by Arthur Gomes at 04/03/19 12:49 - contact me at devarthur4718@gmail.com.br
class AndroidSamples : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_android_samples, container, false)
    }


}
