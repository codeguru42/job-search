package codeguru.jobsearch.ui

import android.app.Instrumentation
import android.content.Context
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.action.ViewActions.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import codeguru.jobsearch.db.JobSearchDatabase
import codeguru.jobsearch.db.Position
import codeguru.jobsearch.db.PositionDao
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class TestPositionDetails {
    @get:Rule
    val composeRule = createComposeRule()

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

        composeRule.setContent {
            JobDetailsScreen(modifier = Modifier)
        }

        composeRule.onNodeWithText("Title")
            .performTextInput(title)
        composeRule.onNodeWithText("Company")
            .performTextInput(company)
        composeRule.onNodeWithContentDescription("Save Position Details")
            .performClick()

        val latch = CountDownLatch(1);
        instrumentation.runOnMainSync {
            val livePositions = positionDao.getPositions()
            livePositions.observeForever { positions ->
                if (positions.isNotEmpty()) {
                    latch.countDown()
                    assertThat(positions[0]).isEqualTo(position)
                }
            }
        }
        assertThat(latch.await(2, TimeUnit.SECONDS)).isTrue()
    }
}
