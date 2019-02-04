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

               val tagName = xpp.name.toLowerCase() // TODO we should to the safe call ?
                when(eventType){
                    XmlPullParser.START_TAG -> {
                         Log.d(TAG, "parse : Starting tag for " + tagName)
                         if(tagName == "entry"){
                             inEntry = true
                         }
                    }
                    XmlPullParser.TEXT -> textValue = xpp.text

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
                                "name" -> currentRecord.name = textValue
                                "artist" -> currentRecord.artist = textValue
                                "releaseDate" -> currentRecord.releaseDate = textValue
                                "summary" -> currentRecord.summary = textValue
                                "image" -> currentRecord.summary = textValue
                            }

                        }
                    }
                }
            }

        }catch (e : Exception){
            e.printStackTrace()
            //Something went wrong, change status
            status = false
        }

        return status
    }
}