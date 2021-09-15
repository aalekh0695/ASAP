package com.example.asap.model

import android.media.Rating

data class Deals(val image: Int, val title: String)

data class Restaurants (val image: Int, val name: String,
                        val cuisine : String, val price : String,
                        val discountOffer : String)

data class RestaurantDish(val image: Int, val name: String,
                          val price: String, val rating: String,
                          val description : String)

