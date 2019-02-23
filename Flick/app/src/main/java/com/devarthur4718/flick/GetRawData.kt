package com.devarthur4718.flick

import android.os.AsyncTask
import android.util.Log
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

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

        try{
            downloadStatus = DonwloadStatus.OK
            return URL(params[0]).readText()
        }catch (e: Exception){

            val errorMessage = when(e){
                is MalformedURLException ->{
                    downloadStatus = DonwloadStatus.NOT_INITIALISED
                    "doInBackground : Invalid URL ${e.message}"

                }
                is IOException ->{
                    downloadStatus = DonwloadStatus.FAILED_OR_EMPTY
                    "doInBackground : IO Exception reading data:  ${e.message}"

                }
                is SecurityException ->{
                    downloadStatus = DonwloadStatus.PERMISSIONS_ERROR
                    "doInBackground : Security Exception:  ${e.message}"

                }
                else ->{
                    downloadStatus = DonwloadStatus.ERROR
                    "Unknown error:  ${e.message}"
                }
            }
            Log.e(TAG, errorMessage)
            return errorMessage
        }
    }
}