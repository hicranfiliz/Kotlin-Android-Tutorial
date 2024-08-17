package com.example.sampleapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BMICalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator)

        // get user inputs
        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)

        val calcButton = findViewById<Button>(R.id.btnCalculate)

        calcButton.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()
            if (validateInput(weight,height)){
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))

                // get result with two decimal places
                val bmi2Digits = String.format("%.2f",bmi).toFloat()

                displayResult(bmi2Digits)
            }
        }
    }

    private fun validateInput(weight : String? , height : String?) : Boolean{
        return when{
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty() ->{
                Toast.makeText(this, "Height is empty", Toast.LENGTH_LONG).show()
                return false
            }

            else -> {
                return true
            }
        }
    }


    private fun displayResult(bmi: Float){
        val resultIndex = findViewById<TextView>(R.id.tvIndex)
        val resultDesc = findViewById<TextView>(R.id.tvResult)
        val info = findViewById<TextView>(R.id.tvInfo)

        resultIndex.text = bmi.toString()
        info.text = "(normal range is 18.5 - 24.9)"

        var color = 0

        when{
            bmi < 18.50 -> {
                resultDesc.text = "Underweight"
                color = R.color.underweight
            }
            bmi in 18.50..24.9 ->{
                resultDesc.text = "Healty"
                color = R.color.normal
            }
            bmi in 25.00..29.99 ->{
                resultDesc.text = "Overweight"
                color = R.color.overweight
            }
            bmi > 29.99 -> {
                resultDesc.text = "Obese"
                color = R.color.obese
            }
        }

        resultDesc.setTextColor(ContextCompat.getColor(this, color))
    }
}