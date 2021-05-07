package codeguru.jobsearch.ui

import android.app.Instrumentation
import android.content.Context
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import codeguru.jobsearch.R
import codeguru.jobsearch.db.JobSearchDatabase
import codeguru.jobsearch.db.Position
import codeguru.jobsearch.db.PositionDao
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TestPositionDetails {
    private lateinit var positionDao: PositionDao
    private lateinit var db: JobSearchDatabase
    private lateinit var instrumentation: Instrumentation

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        instrumentation = InstrumentationRegistry.getInstrumentation()
        db = Room.inMemoryDatabaseBuilder(
            context, JobSearchDatabase::class.java).build()
        positionDao = db.getPositionDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    fun testCreatePosition() {
        val title = "Software Engineer"
        val company = "Google"
        val position = Position(1, title, company)

        val positionDetailsScenario = launchFragmentInContainer<PositionDetails>()

        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        positionDetailsScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.nav_graph)
            navController.setCurrentDestination(R.id.PositionDetail)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        onView(withId(R.id.text_title))
            .perform(typeText(title))
        onView(withId(R.id.text_business_name))
            .perform(
                typeText(company),
                closeSoftKeyboard()
            )
        onView(withId(R.id.position_save)).perform(click())

        instrumentation.runOnMainSync {
            val livePositions = positionDao.getPositions()
            livePositions.observeForever { positions ->
                assertThat(positions[0]).isEqualTo(position)
            }
        }
    }
}
