package com.example.intentlogindashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import coil.load

class GridImageAdapter(
    private val context: Context,
    private val items: List<GridImageItem>,
    private val selectionChangeListener: () -> Unit
) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = items[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.grid_item_layout, parent, false)
            holder = ViewHolder(
                imageView = view.findViewById(R.id.gridImageView),
                tvTitle = view.findViewById(R.id.tvTitle),
                tvSubtitle = view.findViewById(R.id.tvSubtitle),
                overlay = view.findViewById(R.id.selectedOverlay),
                checkIconContainer = view.findViewById(R.id.checkIconContainer),
                popupIconContainer = view.findViewById(R.id.popupIconContainer)
            )
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val item = items[position]

        // Bind Text Data
        holder.tvTitle.text = item.title
        holder.tvSubtitle.text = item.subtitle

        // Load Image based on type
        if (item.type == ImageSourceType.DRAWABLE) {
            holder.imageView.setImageResource(item.source as Int)
        } else if (item.type == ImageSourceType.URL) {
            // Using Coil to load the URL
            holder.imageView.load(item.source as String) {
                crossfade(true)
                placeholder(android.R.drawable.ic_menu_gallery)
            }
        }

        // Handle Selected State
        if (item.isSelected) {
            holder.overlay.visibility = View.VISIBLE
            holder.checkIconContainer.visibility = View.VISIBLE
        } else {
            holder.overlay.visibility = View.GONE
            holder.checkIconContainer.visibility = View.GONE
        }

        // Handle entire item click via adapter to trigger callback
        view.setOnClickListener {
            item.isSelected = !item.isSelected
            notifyDataSetChanged()
            selectionChangeListener.invoke()
        }

        // Handle Popup Menu Icon
        if (item.hasPopupMenu) {
            holder.popupIconContainer.visibility = View.VISIBLE
            holder.popupIconContainer.setOnClickListener {
                showPopupMenu(holder.popupIconContainer, position)
            }
        } else {
            holder.popupIconContainer.visibility = View.GONE
            holder.popupIconContainer.setOnClickListener(null)
        }

        return view
    }

    private fun showPopupMenu(anchor: View, position: Int) {
        val popup = PopupMenu(context, anchor)
        popup.menuInflater.inflate(R.menu.item_popup_menu, popup.menu)
        
        popup.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.popup_view -> {
                    Toast.makeText(context, "View clicked for item $position", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.popup_share -> {
                    Toast.makeText(context, "Share clicked for item $position", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.popup_delete -> {
                    Toast.makeText(context, "Delete clicked for item $position", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    private class ViewHolder(
        val imageView: ImageView,
        val tvTitle: TextView,
        val tvSubtitle: TextView,
        val overlay: View,
        val checkIconContainer: View,
        val popupIconContainer: View
    )
}
