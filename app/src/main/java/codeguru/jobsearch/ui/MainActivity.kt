package codeguru.jobsearch.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.room.Room
import codeguru.jobsearch.JobSearchNavHost
import codeguru.jobsearch.R
import codeguru.jobsearch.db.JobSearchDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }

        val db = Room.databaseBuilder(
            this,
            JobSearchDatabase::class.java,
            "job_search"
        ).build()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun App(modifier: Modifier = Modifier) {
    MaterialTheme {
        JobSearchNavHost(modifier = modifier)
    }
}
