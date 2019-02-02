package madcode.aula.listview

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "on Create called")
        val downloadData = DownloadData()
        downloadData.execute("URL Goes here")
        Log.d(TAG, "on Create done")


    }

    companion object {
        //An async task is executed by another thread in the operating system
        //We should actually avoid using this method, but this is just a sample code.
        private class DownloadData: AsyncTask<String, Void, String>(){
            private val TAG = "DownloadData"
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                Log.d(TAG, "OnPostExecute: parameter is $result")
            }

            override fun doInBackground(vararg url: String?): String {
                Log.d(TAG, "doInBackground : starts with ${url[0]}")
                val rssFeed = downloadXML(url[0])
                if(rssFeed.isEmpty()){
                    Log.e(TAG, "doInBackground : Error Downloading")
                }
                return rssFeed

            }


        }
    }
    private fun downloadXML(urlPath: String?): String {
        //Used to concatenate a lot of strings
        val xmlResult = StringBuilder()

        try {
            //If we have a connection
            val url = URL(urlPath)
            val connection : HttpURLConnection = url.openConnection() as HttpURLConnection
            val response = connection.responseCode
            Log.d(TAG, "downloadXML: The response code $response")

//            val inputStream = connection.inputStream
//            val inputStreamReader = InputStreamReader(inputStream)
//            val reader = BufferedReader(inputStreamReader)
            val reader = BufferedReader(InputStreamReader(connection.inputStream))

        }catch (e : MalformedURLException){
            //Catch if the url is a bad one
            Log.e(TAG, "downloadXML: Invalid URL ${e.message}")
        }catch (e : IOException){
            //Catch if there is a problem with our connection
            Log.e(TAG, "downloadXML: IO Exception while reading data ${e.message}")
        }catch (e : Exception){
            //Catch if there is a problem with our connection
            Log.e(TAG, "downloadXML: Unknow error ${e.message}")
        }

    }
}
