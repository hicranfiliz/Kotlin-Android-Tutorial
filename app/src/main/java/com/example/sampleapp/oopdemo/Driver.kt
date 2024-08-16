package com.example.sampleapp.oopdemo

import android.util.Log

class Driver(var name: String, credit: Int) {
    //var driverName = ""

    // bir variable'ın atamasini daha sonra yapabilmek icin lateinit var kullanabilirim ama tipini mutlaka belirtmem gerekli!!
    //lateinit var driverName : String

   // var driverName = name

    private val car = Car()

    private var totalCredit = 50

    init {
        totalCredit += credit
       // driverName = name

        // car classının memberlarina sadece init blogunda erisebilriim cunku class cagrildiginda ilk once
        // Burasi calisir.
        car.maxSpeed = 150
        car.start()
    }

    fun showDetails(){
        Log.i("Mytag","Name of the driver is $name")
        Log.i("Mytag","Credit of the driver is $totalCredit")
    }
}