package com.example.stopwatch

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

lateinit var startButton : Button
lateinit var resetButton : Button
lateinit var stopButton : Button

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
        TODO("Not yet implemented")
    }

    private fun stopStopWatch() {
        TODO("Not yet implemented")
    }

    private fun startStopWatch() {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }





    private fun wireWidgets() {
        startButton = findViewById(R.id.button_main_start)
        resetButton = findViewById(R.id.button_main_reset)
        stopButton = findViewById(R.id.button_main_stop)

        stopButton.visibility = View.GONE
    }
}