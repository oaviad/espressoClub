package com.espresso.espressoclub

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.att.espressoclub.R
import com.att.espressoclub.ui.MainActivity
import com.att.espressoclub.ui.login.INTENT_EXTRA_DISPLAY_NAME
import com.att.espressoclub.ui.login.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val USER_NAME = "test@gmail.com"
private const val VALID_PASSWORD = "123456"

@RunWith(AndroidJUnit4::class)
class IntentsExampleTest {

    /**
     * Use [IntentsTestRule] to initialize Espresso-Intents before each test
     * and releases Espresso-Intents after each test run.
     */
    @get:Rule
    val rule = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun validateMainActivityIntent() {

        // Type user name.
        onView(withId(R.id.usernameEditText))
            .perform(typeText(USER_NAME), ViewActions.closeSoftKeyboard())
        // Type valid password.
        onView(withId(R.id.passwordEditText))
            .perform(typeText(VALID_PASSWORD), ViewActions.closeSoftKeyboard())
        // Click the login button.
        onView(withId(R.id.login)).perform(click())

        // Validate the Intent.
        Intents.intended(IntentMatchers.hasComponent(MainActivity::class.java.name))
        Intents.intended(IntentMatchers.hasExtra(INTENT_EXTRA_DISPLAY_NAME, USER_NAME))
    }
}