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
            while (eventType != XmlPullParser.END_DOCUMENT){ // Continue searching the entire XML document for relevant tags

               val tagName = xpp.name?.toLowerCase()
                when(eventType){
                    XmlPullParser.START_TAG -> {
                         Log.d(TAG, "parse : Starting tag for " + tagName)
                         if(tagName == "entry"){
                             inEntry = true
                         }
                    }
                    XmlPullParser.TEXT -> textValue = xpp.text // parse looking for the right data

                    XmlPullParser.END_TAG ->{
                        Log.d(TAG, "parse: Ending tag for " + tagName)
                        if(inEntry){
                            when(tagName){
                                //Selecting the content from each tag in XML file
                                "entry" -> {
                                    applications.add(currentRecord)
                                    inEntry = false
                                    currentRecord = FeedEntry() //Create a new object from the feedlist

                                }
                                //Geetting the fields from the XML file that we are interested
                                "name" -> currentRecord.name = textValue
                                "artist" -> currentRecord.artist = textValue
                                "releaseDate" -> currentRecord.releaseDate = textValue
                                "summary" -> currentRecord.summary = textValue
                                "image" -> currentRecord.summary = textValue
                            }

                        }
                    }
                }
                eventType = xpp.next()
            }
            //Print and end of file marker to logcat to every entry.
            for (app in applications) {
                Log.d(TAG,"*******************")
                Log.d(TAG,app.toString())
            }
        }catch (e : Exception){
            e.printStackTrace()
            //Something went wrong, change status
            status = false
        }

        return status
    }
}