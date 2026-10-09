package com.example.intentlogindashboard

enum class ImageSourceType {
    DRAWABLE, URL
}

data class GridImageItem(
    val id: Int,
    val type: ImageSourceType,
    val source: Any, // Int for Drawable, String for URL
    val title: String,
    val subtitle: String,
    var isSelected: Boolean = false,
    val hasPopupMenu: Boolean = false
)
