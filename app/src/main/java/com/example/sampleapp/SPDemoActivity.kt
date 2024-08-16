package com.example.sampleapp

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SPDemoActivity : AppCompatActivity() {
    private lateinit var nameText : EditText
    private lateinit var ageText : EditText
    private lateinit var sp : SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spdemo)

        nameText  = findViewById(R.id.etName)
        ageText = findViewById(R.id.etage)
        sp = getSharedPreferences("my_sp", MODE_PRIVATE)
        editor = sp.edit()
    }

    override fun onPause() {
        super.onPause()
        val name  = nameText.text.toString()
        val age = ageText.text.toString().toInt()
        editor.apply{
            putString("sp_name", name)
            putInt("sp_age", age)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val name = sp.getString("sp_name", null)
        val age = sp.getInt("sp_age", 0)

        nameText.setText(name)
        if (age != 0){
            ageText.setText(age.toString())
        }

    }
}