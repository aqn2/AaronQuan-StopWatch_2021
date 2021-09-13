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
import java.util.*

lateinit var startButton : Button
lateinit var resetButton : Button
lateinit var stopButton : Button

lateinit var chronometer : Chronometer

var time = 0;
//lateinit var stopChronometer: Chronometer

class MainActivity : AppCompatActivity() {
    companion object{
        //"static" constants go here yeet
        val TAG = "MainActivity" //for constants ( FINAL)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wireWidgets()

        startButton.setOnClickListener(){
            startStopWatch()
        }

        stopButton.setOnClickListener(){
            stopStopWatch()
        }

        resetButton.setOnClickListener(){
            resetStopWatch()
        }



    }

    private fun resetStopWatch() {
        time = 0
        chronometer.setBase(SystemClock.elapsedRealtime())
        //chronometer.setBase(SystemClock.elapsedRealtime() - (0 * 1000))
        //if you replace the 0 with 17 it stays at 17 and so forth, so with 0 it starts at zero but 0*1000 = 0
        stopButton.visibility = View.GONE
        startButton.visibility = View.VISIBLE
        chronometer.stop()
    }

    private fun stopStopWatch() {
        time = (chronometer.getBase() - SystemClock.elapsedRealtime()).toInt()
        stopButton.visibility = View.GONE
        startButton.visibility = View.VISIBLE
        chronometer.stop()


    }

    private fun startStopWatch() {
        chronometer.setBase(SystemClock.elapsedRealtime() + time.toLong())
        startButton.visibility = View.GONE
        stopButton.visibility = View.VISIBLE
        chronometer.start()
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

    }
}