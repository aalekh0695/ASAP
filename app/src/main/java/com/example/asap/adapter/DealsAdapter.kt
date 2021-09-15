package com.example.asap.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.asap.R
import com.example.asap.model.Deals

class DealsAdapter(private val dealsList: List<Deals>) : RecyclerView.Adapter<DealsAdapter.DealsHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class DealsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView : ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.textViewDealsTitle)
            imageView = view.findViewById(R.id.dealsImage)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): DealsHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.home_recycler_view_horizontal_item, viewGroup, false)

        return DealsHolder(view)
    }

    override fun onBindViewHolder(holder: DealsHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val deals = dealsList[position]
        holder.textView.text = deals.title
        holder.imageView.setImageResource(deals.image)
    }

    override fun getItemCount() = dealsList.size

}