package madcode.aula.listview

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
    //An async task is executed by another thread in the operating system
    //We should actually avoid using this method, but this is just a sample code.
    private inner class DownloadData: AsyncTask<String, Void, String>(){

    }
}
