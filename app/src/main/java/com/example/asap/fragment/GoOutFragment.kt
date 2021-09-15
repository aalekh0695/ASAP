package com.example.asap.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asap.R
import com.example.asap.adapter.DealsAdapter
import com.example.asap.adapter.RestaurantAdapter
import com.example.asap.databinding.FragmentGoOutBinding
import com.example.asap.model.Deals
import com.example.asap.model.Restaurants


/**
 * A simple [Fragment] subclass.
 * Use the [GoOutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GoOutFragment : Fragment(), RestaurantAdapter.OnRestaurantItemClickListener {
    private val TAG = "GoOutFragment"

    private lateinit var recyclerViewHorizontal: RecyclerView
    private lateinit var recyclerViewVertical: RecyclerView
    private var _binding: FragmentGoOutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_go_out, container, false)

        _binding = FragmentGoOutBinding.inflate(inflater, container, false)
        val view = binding.root
        recyclerViewHorizontal = binding.goOutFragRecyclerView

        recyclerViewVertical = binding.goOutFragVerticalRecyclerView

        val dealsList = listOf<Deals>(
            Deals(R.drawable.food_image_1, "EPIC DEALS"),
            Deals(R.drawable.food_image_2, "40% OFF"),
            Deals(R.drawable.food_image_3, "ENJOY FOOD"),
            Deals(R.drawable.food_image_4, "DON'T STAY HUNGRY")
        )

        val restaurantList = listOf<Restaurants>(
            Restaurants(
                R.drawable.restaurant_1, "Le Tavern Frill",
                "Chinese", "220 per person", "50% OFF"
            ),
            Restaurants(
                R.drawable.restaurant_2, "Rasta Cafe",
                "Chinese", "220 per person", "50% OFF"
            ),
            Restaurants(
                R.drawable.restaurant_3, "Ant Hill",
                "Chinese", "220 per person", "50% OFF"
            ),
            Restaurants(
                R.drawable.restaurant_4, "Mighty Paws",
                "Chinese", "220 per person", "50% OFF"
            ),
            Restaurants(
                R.drawable.restaurant_5, "Social House",
                "Chinese", "220 per person", "50% OFF"
            ),
            Restaurants(
                R.drawable.restaurant_6, "Bathinda Junction",
                "Chinese", "220 per person", "50% OFF"
            ),
            Restaurants(
                R.drawable.restaurant_7, "Cavelry",
                "Chinese", "220 per person", "50% OFF"
            )
        )

        val dealsAdapter = DealsAdapter(dealsList)
        recyclerViewHorizontal.adapter = dealsAdapter
        recyclerViewHorizontal.layoutManager = LinearLayoutManager(
            view.context,
            LinearLayoutManager.HORIZONTAL, false
        )

        val restaurantAdapter = RestaurantAdapter(restaurantList, this)
        recyclerViewVertical.adapter = restaurantAdapter
        recyclerViewVertical.layoutManager = LinearLayoutManager(view.context)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onRestaurantClicked(position: Int) {
        Log.i(TAG, "onRestaurantClicked: $position")
        val restaurantDetailsFragment = RestaurantDetailsFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.homeFragmentContainer, restaurantDetailsFragment, "findThisFragment")
            .addToBackStack(null)
            .commit()

    }
}