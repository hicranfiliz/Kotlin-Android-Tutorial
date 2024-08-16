package com.example.sampleapp.oopdemo

import android.util.Log

class MyCar : Car() , SpeedController{
    override fun start() {
        Log.i("Mytag","Started mycar class ... Brand id is: ${getBrandId()}")
    }

    override fun accelerate() {
        TODO("Not yet implemented")
    }

    override fun decelerate() {
        TODO("Not yet implemented")
    }
}