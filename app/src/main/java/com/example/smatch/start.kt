package com.example.smatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class start : AppCompatActivity() {

    lateinit var logoLeft : ImageView
    lateinit var logoRight : ImageView
    lateinit var goleft : Animation
    lateinit var goright : Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val intentProfile = Intent(this, profile::class.java)
        val countDown: CountDownTimer = object : CountDownTimer(1000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                logoLeft.startAnimation(goright)
                logoRight.startAnimation(goleft)
            }

            override fun onFinish() {
                startActivity(intentProfile)
            }
        }

        logoLeft = findViewById(R.id.logoleft)
        logoRight = findViewById(R.id.logoright)
        goleft = AnimationUtils.loadAnimation(this, R.anim.goleft)
        goright = AnimationUtils.loadAnimation(this, R.anim.goright)

        countDown.start()
    }
}