package com.example.intentlogindashboard

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ImageGridActivity : AppCompatActivity() {

    private lateinit var gridView: GridView
    private lateinit var adapter: GridImageAdapter
    private lateinit var imageList: MutableList<GridImageItem>
    private var allSelected = false

    private fun updateSelectionCount() {
        val selectedCount = imageList.count { it.isSelected }
        val tvSelectionCount = findViewById<android.widget.TextView>(R.id.tvSelectionCount)
        tvSelectionCount.text = "$selectedCount / ${imageList.size} SELECTED"
        allSelected = selectedCount == imageList.size
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_grid)

        // Setup Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Image Gallery"

        gridView = findViewById(R.id.gridView)

        // Initialize Data (3 Custom Drawables, 6 URLs)
        imageList = mutableListOf(
            GridImageItem(1, ImageSourceType.DRAWABLE, R.drawable.grid_sample_1, "Sunrise Gradient", "drawable_sample.xml", false, true),
            GridImageItem(2, ImageSourceType.DRAWABLE, R.drawable.grid_sample_2, "Purple Haze", "drawable_sample.xml", false, true),
            GridImageItem(3, ImageSourceType.DRAWABLE, R.drawable.grid_sample_3, "Ocean Mint", "drawable_sample.xml", false, true),
            
            GridImageItem(4, ImageSourceType.URL, "https://images.unsplash.com/photo-1449844908441-8829872d2607?q=80&w=400", "Mountain Lake", "unsplash.com", false, true),
            GridImageItem(5, ImageSourceType.URL, "https://images.unsplash.com/photo-1469474968028-56623f02e42e?q=80&w=400", "Forest Stream", "unsplash.com", false, true),
            GridImageItem(6, ImageSourceType.URL, "https://images.unsplash.com/photo-1473496169904-658ba37448eb?q=80&w=400", "Coastal Cliff", "unsplash.com", false, true),
            
            GridImageItem(7, ImageSourceType.URL, "https://images.unsplash.com/photo-1507525428034-b723cf961d3e?q=80&w=400", "Sandy Beach", "unsplash.com", false, true),
            GridImageItem(8, ImageSourceType.URL, "https://images.unsplash.com/photo-1472214103451-9374bd1c798e?q=80&w=400", "Autumn Trees", "unsplash.com", false, true),
            GridImageItem(9, ImageSourceType.URL, "https://images.unsplash.com/photo-1464822759023-fed622ff2c3b?q=80&w=400", "Mountain Peak", "unsplash.com", false, true)
        )

        adapter = GridImageAdapter(this, imageList) {
            updateSelectionCount()
        }
        gridView.adapter = adapter

        // Bottom Actions Setup
        findViewById<android.widget.TextView>(R.id.btnSelectAll).setOnClickListener {
            for (imageItem in imageList) {
                imageItem.isSelected = true
            }
            adapter.notifyDataSetChanged()
            updateSelectionCount()
        }

        findViewById<android.widget.TextView>(R.id.btnClearSelection).setOnClickListener {
            for (imageItem in imageList) {
                imageItem.isSelected = false
            }
            adapter.notifyDataSetChanged()
            updateSelectionCount()
        }

        findViewById<android.widget.TextView>(R.id.btnViewSelected).setOnClickListener {
            val selectedCount = imageList.count { it.isSelected }
            android.widget.Toast.makeText(this, "Viewing $selectedCount selected items", android.widget.Toast.LENGTH_SHORT).show()
        }

        // Hide default action bar as we have custom top bar
        supportActionBar?.hide()
    }
}
