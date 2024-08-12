package com.example.sampleapp

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get the text, edittext and button
        val greetingTextView = findViewById<TextView>(R.id.tvHello)
        val inputField = findViewById<EditText>(R.id.etName)
        val submitButton = findViewById<Button>(R.id.btnSubmit)
        val openSecButton = findViewById<Button>(R.id.btnOpenSecond)
        var enteredName = ""

        // implement the onclick listener of the button
        // inputField.text -> give us the value of edittext as an editable object
        submitButton.setOnClickListener{
            enteredName = inputField.text.toString()

            if (enteredName == ""){
                openSecButton.visibility = INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(
                    this@MainActivity,
                    "Please enter your name!",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                val message = "Welcome $enteredName"
                greetingTextView.text = message
                inputField.text.clear()
                openSecButton.visibility = VISIBLE
            }
        }

        // send parameter to the second activity with PUTEXTRA
        openSecButton.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", enteredName)
            startActivity(intent)
        }
    }
}