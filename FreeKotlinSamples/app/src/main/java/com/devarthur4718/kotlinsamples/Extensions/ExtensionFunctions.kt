package com.devarthur4718.kotlinsamples.Extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//* Created by Arthur Gomes at 04/03/19 12:49 - contact me at devarthur4718@gmail.com.br
//Extension function
//Content from:
//https://antonioleiva.com/extension-functions-kotlin/

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}