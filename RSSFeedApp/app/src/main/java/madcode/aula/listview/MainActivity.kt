package madcode.aula.listview

import android.content.Context
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import kotlin.properties.Delegates


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

    private var downloadData : DownloadData? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val baseurl : String = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml"

        downloadUrl(baseurl)
        Log.d(TAG, "on Create done: ")


    }

    //Called when its time to inflate te activity menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.feeds_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val feedUrl : String

        when(item.itemId){
            R.id.mnuFree ->
                feedUrl = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml"
            R.id.mnuPaid ->
                feedUrl = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/toppaidapplications/limit=10/xml"
            R.id.mnuSongs ->
                feedUrl = "http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=10/xml"
            else ->
                return super.onOptionsItemSelected(item)
        }
        downloadUrl(feedUrl)
        return true
    }

    private fun downloadUrl(feedUrl: String) {

        Log.d(TAG, "download URL initiating async task")
        //Download the data from the http request with an async task - running alongside main thread
        downloadData = DownloadData(this, xmlListView)
        downloadData?.execute(feedUrl)
        Log.d(TAG, "on Create done")

    }

    override fun onDestroy() {
        //If activity is destroyed and the async task still downloading information we stop it
        //preventing the app from crashing
        super.onDestroy()
        //Stop the task if the activity is being destroyed...
        downloadData?.cancel(true)
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
