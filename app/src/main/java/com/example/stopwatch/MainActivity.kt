package com.example.stopwatch

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
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
    }
}