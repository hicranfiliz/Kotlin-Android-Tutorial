package com.example.sampleapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // for access the previous screen's data
        val userName = intent.getStringExtra("USER")
        val textView = findViewById<TextView>(R.id.tvOffer)
        val message = "$userName, you will get free access to all the content for one month"
        textView.text = message
    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", " SECONDACTIVITY ONSTART ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", " SECONDACTIVITY onresume ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", " SECONDACTIVITY ONPAUSE ")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG", " SECONDACTIVITY ONSTOP ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG", " SECONDACTIVITY ON DESTROY ")
    }
}