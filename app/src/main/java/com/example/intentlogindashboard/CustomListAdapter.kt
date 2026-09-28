package com.example.intentlogindashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Custom Adapter to map our ListItem data to the list_item_card.xml layout.
 * This is what makes the UI "Adaptive".
 */
class CustomListAdapter(context: Context, private val dataSource: List<ListItem>) :
    ArrayAdapter<ListItem>(context, R.layout.list_item_card, dataSource) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView

        // Reuse the view if it already exists (View Recycling pattern)
        if (view == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item_card, parent, false)
        }

        // Get the data item for this position
        val currentItem = dataSource[position]

        // Find the views within the list_item_card.xml layout
        val imageView = view!!.findViewById<ImageView>(R.id.itemImageView)
        val titleView = view.findViewById<TextView>(R.id.itemTitleTextView)
        val subtitleView = view.findViewById<TextView>(R.id.itemSubtitleTextView)

        // Populate the views with data
        imageView.setImageResource(currentItem.imageResId)
        titleView.text = currentItem.title
        subtitleView.text = currentItem.subtitle

        return view
    }
}
