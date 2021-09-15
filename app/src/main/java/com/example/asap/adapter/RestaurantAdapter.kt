package com.example.asap.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.asap.R
import com.example.asap.model.Restaurants

class RestaurantAdapter(private val restaurantList: List<Restaurants>,
                        private val onRestaurantItemClickListener: OnRestaurantItemClickListener
                        ) : RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder>() {

    class RestaurantHolder(
        itemView: View,
        onRestaurantItemClickListener: OnRestaurantItemClickListener
    ) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val imageView : ImageView
        val name : TextView
        val price : TextView
        val cuisine : TextView
        val discount : TextView
        private val onRestaurantItemClickListener : OnRestaurantItemClickListener

        init {
            imageView = itemView.findViewById(R.id.dishImage)
            name = itemView.findViewById(R.id.textviewDishName)
            price = itemView.findViewById(R.id.textViewDishStarRating)
            discount = itemView.findViewById(R.id.textViewDishDescription)
            cuisine = itemView.findViewById(R.id.textViewDishPrice)
            this.onRestaurantItemClickListener = onRestaurantItemClickListener

            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onRestaurantItemClickListener.onRestaurantClicked(adapterPosition)
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RestaurantHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.home_recycler_view_vertical_item, viewGroup, false)

        return RestaurantHolder(view, onRestaurantItemClickListener)
    }

    override fun onBindViewHolder(holder: RestaurantHolder, position: Int) {
        val restaurant = restaurantList[position]

        holder.imageView.setImageResource(restaurant.image)
        holder.name.text = restaurant.name
        holder.price.text = restaurant.price
        holder.discount.text = restaurant.discountOffer
        holder.cuisine.text = restaurant.cuisine


    }

    override fun getItemCount() = restaurantList.size

    interface OnRestaurantItemClickListener {
        fun onRestaurantClicked(position: Int)
    }

}