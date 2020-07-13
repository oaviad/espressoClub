package com.att.espressoclub.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.att.espressoclub.R
import com.att.espressoclub.ui.login.INTENT_EXTRA_DISPLAY_NAME
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        welcomeTextView.text = "Welcome\n ${intent.getStringExtra(INTENT_EXTRA_DISPLAY_NAME)}!"
    }
}