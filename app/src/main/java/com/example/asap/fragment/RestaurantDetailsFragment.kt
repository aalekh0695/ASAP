package com.example.asap.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asap.R
import com.example.asap.adapter.RestaurantAdapter
import com.example.asap.adapter.RestaurantDishAdapter
import com.example.asap.model.RestaurantDish

/**
 * A simple [Fragment] subclass.
 * Use the [RestaurantDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantDetailsFragment : Fragment() {

    private lateinit var fragRestaurantDishRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_restaurant_details, container, false)

        fragRestaurantDishRecyclerView = view.findViewById(R.id.restaurantFragmentRecyclerView)

        val dishList = listOf<RestaurantDish>(
            RestaurantDish(R.drawable.food_image_1, "Tandoori Chicken", "220",
                "4.5", "Yummy Description"),
            RestaurantDish(R.drawable.food_image_2, "Tandoori Chicken", "220",
                "4.5", "Yummy Description"),
            RestaurantDish(R.drawable.food_image_3, "Tandoori Chicken", "220",
                "4.5", "Yummy Description"),
            RestaurantDish(R.drawable.food_image_4, "Tandoori Chicken", "220",
                "4.5", "Yummy Description"),
        )

        val restaurantDishAdapter  = RestaurantDishAdapter(dishList)
        fragRestaurantDishRecyclerView.adapter = restaurantDishAdapter
        fragRestaurantDishRecyclerView.layoutManager = LinearLayoutManager(view.context)


        return view
    }

}