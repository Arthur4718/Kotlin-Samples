package madcode.aula.listview

import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import kotlin.properties.Delegates

const val URL = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml"

class FeedEntry{

    var name: String = ""
    var artist: String = ""
    var releaseDate: String = ""
    var summary: String = ""
    var imageURL: String = ""

    override fun toString(): String {
        return """
            name = $name
            artist = $artist
            releaseDate = $releaseDate
            imageURL = $imageURL
        """.trimIndent()
    }
}

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "on Create called")
        val downloadData = DownloadData(this, xmlListView)
        downloadData.execute(URL)
        Log.d(TAG, "on Create done")


    }

    companion object {
        //An async task is executed by another thread in the operating system
        //We should actually avoid using thi    s method, but this is just a sample code.
        private class DownloadData(context : Context, listview : ListView): AsyncTask<String, Void, String>(){
            private val TAG = "DownloadData"

            //Getting the parameters passing through class inicialization
            var propContext : Context by Delegates.notNull()
            var propListView : ListView by Delegates.notNull()

            init{
                //Creating the the properties by initialization
                propContext = context
                propListView = listview
            }

            override fun onPostExecute(result: String) {
                super.onPostExecute(result)
                Log.d(TAG, "OnPostExecute: parameter is $result")
                val parserApplications = ParseApplications()
                parserApplications.parse(result)
                //Creating adapter
                val arrayAdapter = ArrayAdapter<FeedEntry>(propContext, R.layout.list_item, parserApplications.applications)
                propListView.adapter = arrayAdapter
            }

            override fun doInBackground(vararg url: String?): String {
                Log.d(TAG, "doInBackground : starts with ${url[0]}")
                val rssFeed = downloadXML(url[0])
                if(rssFeed.isEmpty()){
                    Log.e(TAG, "doInBackground : Error Downloading")
                }
                return rssFeed

            }

            private fun downloadXML(urlPath: String?): String {
                return URL(urlPath).readText()
            }

        }
    }

}
