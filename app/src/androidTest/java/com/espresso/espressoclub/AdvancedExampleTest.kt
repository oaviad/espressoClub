package com.espresso.espressoclub

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.att.espressoclub.ui.MainActivity
import com.att.espressoclub.ui.login.INTENT_EXTRA_DISPLAY_NAME
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AdvancedExampleTest {

    lateinit var scenario: ActivityScenario<MainActivity>

    @Test
    fun launchMainActivityWithLongDisplayName() {
        val intent = Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
            .putExtra(
                INTENT_EXTRA_DISPLAY_NAME,
                "longDisplayNamelongDisplayNamelongDisplayNamelongDisplayName"
            )
        scenario = launchActivity(intent)
    }

    @After
    fun cleanup() {
        scenario.close()
    }
}