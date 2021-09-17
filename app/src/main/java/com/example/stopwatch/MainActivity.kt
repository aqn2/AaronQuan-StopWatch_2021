package com.example.stopwatch

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageHelper
import java.util.*

lateinit var startButton : Button
lateinit var resetButton : Button
lateinit var stopButton : Button

lateinit var chronometer : Chronometer

//lateinit var startImage : ImageView
//lateinit var stopImage : ImageView

var time = 0;

var isRunning = false;
//lateinit var stopChronometer: Chronometer

class MainActivity : AppCompatActivity() {
    companion object{
        //"static" constants go here yeet
        val TAG = "MainActivity" //for constants ( FINAL)
        val BUNDLE_DISPLAYED_TIME = "displayed time"
        val IS_RUNNING = "isRunning"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()

        time = savedInstanceState?.getInt(BUNDLE_DISPLAYED_TIME) ?:0
        chronometer.base = SystemClock.elapsedRealtime() - time.toLong()
        isRunning = savedInstanceState?.getBoolean(IS_RUNNING) ?: false
        if(savedInstanceState != null)
            if(savedInstanceState.getBoolean(IS_RUNNING)){
                chronometer.start()
                stopButton.visibility = View.VISIBLE
                startButton.visibility = View.GONE
            }

        startButton.setOnClickListener(){
            startStopWatch()
            //startImage.visibility = View.VISIBLE
            //stopImage.visibility = View.INVISIBLE
        }

        stopButton.setOnClickListener(){
            stopStopWatch()
            //startImage.visibility = View.INVISIBLE
            //stopImage.visibility = View.VISIBLE
        }

        resetButton.setOnClickListener(){
            resetStopWatch()
            //startImage.visibility = View.INVISIBLE
            //stopImage.visibility = View.INVISIBLE
        }



    }

    private fun resetStopWatch() {
        isRunning = false
        time = 0
        chronometer.setBase(SystemClock.elapsedRealtime())
        //chronometer.setBase(SystemClock.elapsedRealtime() - (0 * 1000))
        //if you replace the 0 with 17 it stays at 17 and so forth, so with 0 it starts at zero but 0*1000 = 0
        stopButton.visibility = View.GONE
        startButton.visibility = View.VISIBLE
        chronometer.stop()
        //When reset, stop the chronometer and show the start button, remove stop button
    }

    private fun stopStopWatch() {
        isRunning = false
        //time = (chronometer.getBase() - SystemClock.elapsedRealtime()).toInt()
        time = (-chronometer.getBase() + SystemClock.elapsedRealtime()).toInt()
        //the negative time passed when stopwatch stopped is kept by the time showing - the real time
        stopButton.visibility = View.GONE
        startButton.visibility = View.VISIBLE
        chronometer.stop()
        //when stop show the start button move the stop button


    }

    private fun startStopWatch() {
        isRunning = true
        chronometer.setBase(SystemClock.elapsedRealtime() - time.toLong())
        //when you start the stopwatch, it is the real time - the time paused
        startButton.visibility = View.GONE
        stopButton.visibility = View.VISIBLE
        chronometer.start()
        //show the stop button and start chronometer
    }

    private fun updateDisplayTime() {
        if(isRunning) {
            time = (-chronometer.getBase() + SystemClock.elapsedRealtime()).toInt()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d(TAG, "onCreate: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }






    private fun wireWidgets() {
        startButton = findViewById(R.id.button_main_start)
        resetButton = findViewById(R.id.button_main_reset)
        stopButton = findViewById(R.id.button_main_stop)

        stopButton.visibility = View.GONE

        chronometer = findViewById((R.id.chronometer_main_stopwatch))

        //startImage = findViewById(R.id.image_start_view)
        //startImage.visibility = View.INVISIBLE
        //stopImage = findViewById((R.id.image_stop_view))
        //startImage.visibility = View.INVISIBLE

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("displayedTime", "onSaveInstanceState")
        //a budle lets you store key valuye pairs
        updateDisplayTime()
        //key can be any unique text ()
        outState.putInt(BUNDLE_DISPLAYED_TIME, time)
        outState.putBoolean("isRunning", isRunning)

    }
}