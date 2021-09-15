package com.example.asap.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.asap.R
import com.example.asap.model.RestaurantDish

class RestaurantDishAdapter(private val dishList: List<RestaurantDish>) :
    RecyclerView.Adapter<RestaurantDishAdapter.DishViewHolder>() {


    class DishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView : ImageView = itemView.findViewById(R.id.dishImage)
        val tvDishName : TextView = itemView.findViewById(R.id.textviewDishName)
        val tvDishPrice : TextView = itemView.findViewById(R.id.textViewDishPrice)
        val tvDishDescription : TextView = itemView.findViewById(R.id.textViewDishDescription)
        val tvDishRating : TextView = itemView.findViewById(R.id.textViewDishStarRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurant_details_frag_recycler_view_item, parent, false)

        return DishViewHolder(view)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val dish = dishList[position]
        holder.imageView.setImageResource(dish.image)
        holder.tvDishName.text = dish.name
        holder.tvDishDescription.text = dish.description
        holder.tvDishPrice.text = dish.price
        holder.tvDishRating.text = dish.rating
    }

    override fun getItemCount() = dishList.size


}