package codeguru.jobsearch.db

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TestPositionDao {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var positionDao: PositionDao
    private lateinit var db: JobSearchDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
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
    @Throws(Exception::class)
    fun writePosition() {
        val position = Position(1, "Test Position", "Test Company")
        positionDao.insertPositions(position)
        val livePositions = positionDao.getPositions()
        livePositions.observeForever { positions ->
            assertThat(positions.get(0), equalTo(position))
        }
    }
}
