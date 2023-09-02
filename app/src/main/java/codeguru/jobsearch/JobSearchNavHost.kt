package codeguru.jobsearch

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import codeguru.jobsearch.ui.JobDetailsScreen
import codeguru.jobsearch.ui.JobListScreen

@Composable
fun JobSearchNavHost(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "jobList") {
        composable("jobList") { JobListScreen(modifier = modifier, onClickAddJob = { navController.navigate("jobDetails") }) }
        composable("jobDetails") { JobDetailsScreen(modifier = modifier) }
    }
}
