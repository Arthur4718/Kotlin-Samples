package com.devarthur4718.mylibrary.MyToaster

import android.content.Context
import android.widget.Toast

//* Created by Arthur Gomes at 18/03/19 22:34 - contact me at devarthur4718@gmail.com.br

class toaster(){




    fun simpleToast(context : Context, message : String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT ).show();
    }

    fun longToast(context : Context, message : String){
        Toast.makeText(context, message, Toast.LENGTH_LONG ).show();
    }

}