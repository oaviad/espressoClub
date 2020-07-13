package com.espresso.espressoclub

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.att.espressoclub.R
import com.att.espressoclub.ui.login.LoginActivity
import com.espresso.espressoclub.utils.getString
import com.google.common.truth.Truth
import kotlinx.android.synthetic.main.activity_login.*
import org.hamcrest.CoreMatchers.containsString
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val USER_NAME = "test@gmail.com"
private const val VALID_PASSWORD = "123456"
private const val INVALID_PASSWORD = "12345" // Password must be >5 characters

@RunWith(AndroidJUnit4::class)
class BasicExampleTest {

    /**
     * Use [activityScenarioRule] to create and launch the activity under test before each test,
     * and close it after each test. This is a replacement for
     * [androidx.test.rule.ActivityTestRule].
     */
    @get:Rule
    val rule = activityScenarioRule<LoginActivity>()

    @Test
    fun loginWithValidCredentials() {
        // Type user name.
        onView(withId(R.id.usernameEditText))
            .perform(typeText(USER_NAME), ViewActions.closeSoftKeyboard())
        // Type valid password.
        onView(withId(R.id.passwordEditText))
            .perform(typeText(VALID_PASSWORD), ViewActions.closeSoftKeyboard())
        // Validate login button is enabled.
        onView(withId(R.id.login)).check(matches(isEnabled()))
        // Click the login button.
        onView(withId(R.id.login)).perform(click())
        // Validate welcome string contains user name entered.
        onView(withId(R.id.welcomeTextView)).check(matches(withText(containsString(USER_NAME))))
    }

    @Test
    fun loginWithInvalidCredentials() {

        // Type user name.
        onView(withId(R.id.usernameEditText))
            .perform(typeText(USER_NAME), ViewActions.closeSoftKeyboard())
        // Type invalid password.
        onView(withId(R.id.passwordEditText))
            .perform(typeText(INVALID_PASSWORD), ViewActions.closeSoftKeyboard())

        // Validate login button is disabled.
        onView(withId(R.id.login)).check(matches(not(isEnabled())))
        // Validate password error is displayed
        rule.scenario.onActivity {
            Truth.assertThat(it.passwordEditText.error)
                .isEqualTo(getString(R.string.invalid_password))
        }
    }
}