package com.example.asap.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.asap.R
import com.example.asap.databinding.ActivityTestBinding
import com.example.asap.fragment.GoOutFragment
import com.example.asap.fragment.ProFragment
import com.example.asap.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class TestActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityTestBinding
    private val TAG = "TestActivity"

    val goOutFragment = GoOutFragment()
    val proFragment = ProFragment()
    val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.testBottomNavigation

        bottomNavigationView.setOnItemSelectedListener(this)
        bottomNavigationView.selectedItemId = R.id.go_out_page

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.i(TAG, "onNavigationItemSelected: ")

        when(item.itemId) {
            R.id.profile_page -> inflateFragment(profileFragment, "Profile Page")

            R.id.go_out_page -> inflateFragment(goOutFragment, "Go Out Page")

            R.id.pro_page -> inflateFragment(proFragment, "Pro Page")
        }

        return true
    }

    private fun inflateFragment(fragment: Fragment, toastMessage : String) {
        Toast.makeText(baseContext, toastMessage, Toast.LENGTH_SHORT).show()
        supportFragmentManager.beginTransaction()
            .replace(R.id.testFragmentContainer, fragment).commit()
    }
}