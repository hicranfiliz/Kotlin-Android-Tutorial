package com.example.sampleapp.oopdemo

interface SpeedController {
    fun accelerate()
    fun decelerate()

    fun getBrandId(): String {
        return "ad1234"
    }
}