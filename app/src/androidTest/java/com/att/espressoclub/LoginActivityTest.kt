package com.att.espressoclub

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.att.espressoclub.ui.MainActivity
import com.att.espressoclub.ui.login.LoginActivity
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

const val USER_NAME = "test@gmail.com"
const val VALID_PASSWORD = "123456"
const val INVALID_PASSWORD = "12345"

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

//    @get:Rule
//    val rule = ActivityTestRule(LoginActivity::class.java)

    @get:Rule
    val rule = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun loginWithValidCredentials() {
        onView(withId(R.id.usernameEditText))
            .perform(typeText(USER_NAME), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.passwordEditText))
            .perform(typeText(VALID_PASSWORD), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login)).check(matches(isEnabled()))
        onView(withId(R.id.login)).perform(click())
        onView(withId(R.id.welcomeTextView)).check(matches(withText(containsString(USER_NAME))))
    }

    @Test
    fun loginWithInvalidCredentials() {
        onView(withId(R.id.usernameEditText))
            .perform(typeText(USER_NAME), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.passwordEditText))
            .perform(typeText(INVALID_PASSWORD), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login)).check(matches(not(isEnabled())))
    }

    @Test
    fun validateMainActivityIntent_launchedByClickLoginButton() {
        onView(withId(R.id.usernameEditText))
            .perform(typeText(USER_NAME), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.passwordEditText))
            .perform(typeText(VALID_PASSWORD), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.login)).perform(click())
        Intents.intended(IntentMatchers.hasComponent(MainActivity::class.java.name))
        Intents.intended(IntentMatchers.hasExtra("displayName", USER_NAME))
    }
}