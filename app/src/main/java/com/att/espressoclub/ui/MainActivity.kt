package com.att.espressoclub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.att.espressoclub.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        welcomeTextView.text = "Welcome\n ${intent.getStringExtra("displayName")}!"
    }
}