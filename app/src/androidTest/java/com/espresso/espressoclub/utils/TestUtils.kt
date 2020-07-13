package com.espresso.espressoclub.utils

import android.app.Activity
import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage

val context: Context = getInstrumentation().targetContext

fun getString(id: Int): String? {
    return context.resources.getString(id)
}

fun getCurrentActivity(): Activity? {
    var currentActivity: Activity? = null
    getInstrumentation().runOnMainSync {
        run {
            currentActivity =
                ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED)
                    .elementAtOrNull(0)
        }
    }
    return currentActivity
}