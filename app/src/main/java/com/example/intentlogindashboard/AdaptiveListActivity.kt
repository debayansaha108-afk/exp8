package com.example.intentlogindashboard

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdaptiveListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adaptive_list)

        val listView = findViewById<ListView>(R.id.myListView)

        // 1. Prepare the Data Source
        val servicesList = listOf(
            ListItem(android.R.drawable.ic_menu_camera, "Photography", "Capture your best moments"),
            ListItem(android.R.drawable.ic_menu_mapmode, "Maps & Navigation", "Find your way around the world"),
            ListItem(android.R.drawable.ic_menu_call, "Communications", "Stay connected with family"),
            ListItem(android.R.drawable.ic_menu_edit, "Document Editor", "Create and edit text files"),
            ListItem(android.R.drawable.ic_menu_agenda, "Calendar & Events", "Organize your daily schedule"),
            ListItem(android.R.drawable.ic_menu_gallery, "Image Gallery", "Browse your beautiful photos"),
            ListItem(android.R.drawable.ic_menu_share, "Social Sharing", "Share content with friends")
        )

        // 2. Initialize the Custom Adapter
        val adapter = CustomListAdapter(this, servicesList)

        // 3. Bind the Adapter to the ListView
        listView.adapter = adapter

        // 4. Handle Item Clicks
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val clickedItem = servicesList[position]
            Toast.makeText(this, "Clicked on: ${clickedItem.title}", Toast.LENGTH_SHORT).show()
        }
    }
}
