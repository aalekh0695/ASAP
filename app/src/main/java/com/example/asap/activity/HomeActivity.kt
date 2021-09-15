package com.example.asap.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asap.R
import com.example.asap.adapter.DealsAdapter
import com.example.asap.databinding.ActivityHomeBinding
import com.example.asap.fragment.GoOutFragment
import com.example.asap.fragment.ProFragment
import com.example.asap.fragment.ProfileFragment
import com.example.asap.model.Deals
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    private val TAG = "HomeActivity"

    private lateinit var binding: ActivityHomeBinding

    val goOutFragment = GoOutFragment()
    val proFragment = ProFragment()
    val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = binding.homeBottomNavigation

        bottomNavigationView.setOnItemSelectedListener(this)
        bottomNavigationView.selectedItemId = R.id.go_out_page
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> logout()
            R.id.settings -> Toast.makeText(this@HomeActivity, "Settings!!", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        Toast.makeText(this@HomeActivity, "Signing out!!", Toast.LENGTH_SHORT).show()
        gotoSigninActivity()
        finish()
    }

    private fun gotoSigninActivity() {
        val intent = Intent(this@HomeActivity, SignInActivity::class.java)
        startActivity(intent)
        finish()
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
            .replace(R.id.homeFragmentContainer, fragment).commit()
    }
}