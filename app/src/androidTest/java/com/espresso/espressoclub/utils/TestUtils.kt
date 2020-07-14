package com.espresso.espressoclub.utils

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation

val context: Context = getInstrumentation().targetContext

fun getString(id: Int): String? {
    return context.resources.getString(id)
}