package codeguru.jobsearch.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.room.Room
import codeguru.jobsearch.JobSearchNavHost
import codeguru.jobsearch.R
import codeguru.jobsearch.db.JobSearchDatabase
import codeguru.jobsearch.ui.theme.JobSearchTheme

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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun App() {
    JobSearchTheme {
        Scaffold(topBar = { JobSearchAppBar() }) {
            JobSearchNavHost(modifier = Modifier.padding(it))
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun JobSearchAppBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(stringResource(R.string.app_name))
        }
    )
}
