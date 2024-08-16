package com.example.sampleapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sampleapp.oopdemo.Car
import com.example.sampleapp.oopdemo.Driver
import com.example.sampleapp.oopdemo.MyCar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("MYTAG", "Mainactivity: Oncreate")

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
                Log.i("msg",message)
                greetingTextView.text = message
                Log.i("msg","Aftr showing text")
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

        //val car = Car()
        //car.maxSpeed = 50
        //car.start()

        //val driver = Driver("Hicran", 80)
        //driver.showDetails()

        val myCar = MyCar()
        myCar.start()
    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", "MAIN ACTIVITY ONSTART ")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", " MAOINACTIVITY onresume ")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", " MAOINACTIVITY onpause ")
    }


    override fun onStop() {
        super.onStop()
        Log.i("MYTAG", " MAOINACTIVITY ONSTOP ")
    }
}