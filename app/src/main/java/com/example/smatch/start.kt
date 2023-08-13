package com.example.smatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import java.util.Timer
import kotlin.concurrent.timer

class start : AppCompatActivity() {

    lateinit var logoLeft : ImageView
    lateinit var logoRight : ImageView
//    val goleft = AnimationUtils.loadAnimation(this, R.anim.goleft)
//    val goright = AnimationUtils.loadAnimation(this, R.anim.goright)
    var time = 0
    lateinit var timerTask : Timer
    val intentProfile = Intent(this, profile::class.java)

    fun startTimer() {
        timerTask = timer(period = 100) {
            time ++
        }
    }
    fun resetTimer() {
        timerTask ?.cancel()
        time = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val logoLeft : ImageView = findViewById(R.id.logoleft)
        val logoRight : ImageView = findViewById(R.id.logoright)
        var timerTask : Timer? = null

        startTimer()

//        logoLeft.startAnimation(goright)
//        logoRight.startAnimation(goleft)

        if(time == 25){
            resetTimer()
            startActivity(intentProfile)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
}