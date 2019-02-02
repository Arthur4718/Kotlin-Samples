package madcode.aula.listview

import android.util.Log
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory

class ParseApplications {
    private val TAG = "ParseApplications"
    //Create a list do hold entries
    val applications = ArrayList<FeedEntry>()

    fun parse(xmlData : String ) : Boolean{
        Log.d(TAG, "parse called with $xmlData")
        var status = true
        var inEntry = false
        var textValue = ""

        try {
            val factory =  XmlPullParserFactory.newInstance()
            //Setting up the Java xml parser
            factory.isNamespaceAware = true
            val xpp = factory.newPullParser()
            xpp.setInput(xmlData.reader())
            var eventType = xpp.eventType
            var currentRecord = FeedEntry()
            while (eventType != XmlPullParser.END_DOCUMENT){

            }


        }catch (e : Exception){
            e.printStackTrace()
            //Something went wrong, change status
            status = false
        }


        return status

    }

}