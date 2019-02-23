package com.devarthur4718.flick

import android.os.AsyncTask

enum class DonwloadStatus{
    OK,
    IDLE,
    NOT_INITIALISED,
    FAILED_OR_EMPTY,
    PERMISSIONS_ERROR,
    ERROR
}
//* Created by Arthur Gomes at 23/02/19 10:40 - contact me at devarthur4718@gmail.com.br
class GetRawData : AsyncTask<String, Void, String>() {
    private val TAG = "GetRawData"
    private var downloadStatus = DonwloadStatus.IDLE

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
    }

    override fun doInBackground(vararg params: String?): String {
        if(params[0] == null){

            return  "No URL specified"
        }


        return ""


    }
}