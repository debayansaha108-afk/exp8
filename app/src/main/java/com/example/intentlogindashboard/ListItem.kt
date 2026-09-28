package com.example.intentlogindashboard

/**
 * Data class representing a single item in the ListView.
 */
data class ListItem(
    val imageResId: Int, // Resource ID for the image (e.g., R.drawable.ic_launcher_foreground)
    val title: String,
    val subtitle: String
)
