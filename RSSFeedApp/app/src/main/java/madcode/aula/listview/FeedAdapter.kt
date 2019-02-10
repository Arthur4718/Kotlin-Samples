package madcode.aula.listview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ViewHolder(v : View){
    val tvName : TextView = v.findViewById(R.id.tvName)
    val tvArtist : TextView = v.findViewById(R.id.tvArtist)
    val tvSummary : TextView = v.findViewById(R.id.tvSummary)
}

class FeedAdapter(context : Context, val resource : Int, val applications : List<FeedEntry>) : ArrayAdapter<FeedEntry>(context, resource) {
    //Just a tag to use with Log Cat
    private val TAG = "FeedAdapter"

    private val inflater = LayoutInflater.from(context)



    override fun getCount(): Int {
        //How many item there are - So we can create list of view big enough for it
       return applications.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View { // get the data and its position

        //Defining how the view looks like and how it should be inflated in the ListView
        val view : View
        //Reusing the view created by the adapter
        val viewlHolder : ViewHolder

        if(convertView == null){
            Log.d(TAG, "get View called with null convertView")
            view = inflater.inflate(resource, parent, false)
            viewlHolder = ViewHolder(view)
            view.tag = viewlHolder
        }
        else{
            Log.d(TAG, "get View provided a convertview")
            view = convertView
            viewlHolder = view.tag as ViewHolder
        }



        //Get the id for each TextView. Followed by appling the content for each new row of XML inflated in te layout

//        val tvName : TextView = view.findViewById(R.id.tvName)
//        val tvArtist : TextView = view.findViewById(R.id.tvArtist)
//        val tvSummary : TextView = view.findViewById(R.id.tvSummary)

        //Get the current data for the current Row from the list
        val currentData = applications[position]

        //Display the data for the user
        viewlHolder.tvName.text = currentData.name
        viewlHolder.tvArtist.text = currentData.artist
        viewlHolder.tvSummary.text = currentData.summary

        return view
    }
}