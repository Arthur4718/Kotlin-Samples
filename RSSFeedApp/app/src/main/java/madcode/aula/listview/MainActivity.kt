package madcode.aula.listview

import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import kotlin.properties.Delegates

//A list of XML entries containing the top 10 free apps from apple store.
const val FEED_URL = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml"

//Created a class to work as a data-model for the objects that we will be receiving from the feed.
class FeedEntry {
    var name: String = ""
    var artist: String = ""
    var releaseDate: String = ""
    var summary: String = ""
    var imageURL: String = ""

    //By overriding this method we are capable of dividing the content line by line using trimIndent()
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
    //Used as a stardard TAG to search for MainActivity actions in the LogCat
    private val TAG = "MainActivity"

    //By lazy only makes the object initialization being delayed until it is used later
    private val downloadData by lazy { DownloadData(this, xmlListView)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "on Create called")
        //Download the data from the http request with an async task - running alongside main thread
        downloadData.execute(FEED_URL)
        Log.d(TAG, "on Create done")


    }

    override fun onDestroy() {
        //If activity is destroyed and the async task still downloading information we stop it
        //preventing the app from crashing
        super.onDestroy()
        //Stop the task if the activity is being destroyed...
        downloadData.cancel(true)
    }

    companion object {
        //An async task is executed by another thread in the operating system
        //We should actually avoid using this method, but this is just a sample code.
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
                //Creating adapter and fedding the list
//                val arrayAdapter = ArrayAdapter<FeedEntry>(propContext, R.layout.list_item, parserApplications.applications)
//                propListView.adapter = arrayAdapter

                //Usinga custom Adapter and fedding the list
                val feedAdapter = FeedAdapter(propContext, R.layout.list_record, parserApplications.applications)
                propListView.adapter = feedAdapter
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
