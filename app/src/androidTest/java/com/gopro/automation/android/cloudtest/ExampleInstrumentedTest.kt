package com.gopro.automation.android.cloudtest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import com.microsoft.appcenter.espresso.Factory
import com.microsoft.appcenter.espresso.ReportHelper
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {
    @get:Rule var reportHelper: ReportHelper = Factory.getReportHelper()
    @After
    fun tearDown() {
        reportHelper.label("Stopping App")
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        reportHelper.label("Checking the app context")
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.gopro.automation.android.cloudtest", appContext.packageName)
    }

    @Test
    fun clickButtonTest() {
        reportHelper.label("Checking button")
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.textView)).check(ViewAssertions.matches(withText(R.string.new_text)))
    }
}
