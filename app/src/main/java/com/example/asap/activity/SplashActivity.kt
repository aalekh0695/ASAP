package com.example.asap.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.asap.R

class SplashActivity : AppCompatActivity() {
    private val TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed(
            object : Runnable {
                override fun run() {
                    gotoSignInActivity()
                }
            },
        2000)

    }

    private fun gotoSignInActivity() {
        startActivity(Intent(this@SplashActivity, SignInActivity::class.java))
        finish()
    }
}