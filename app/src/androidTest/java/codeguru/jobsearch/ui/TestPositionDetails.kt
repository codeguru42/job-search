package codeguru.jobsearch.ui

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import codeguru.jobsearch.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TestPositionDetails {
    @Test
    fun testCreatePosition() {
        val scenario = launchFragmentInContainer<PositionDetails>()
        scenario.moveToState(Lifecycle.State.STARTED)
        onView(withId(R.id.text_title))
            .perform(typeText("Software Engineer"))
        onView(withId(R.id.text_business_name))
            .perform(
                typeText("Google"),
                closeSoftKeyboard()
            )
        onView(withId(R.id.position_save)).perform(click())
    }
}
