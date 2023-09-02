package codeguru.jobsearch.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import codeguru.jobsearch.R

@Composable
fun JobListScreen() {
    Scaffold (
        topBar = { JobSearchAppBar() },
        floatingActionButton = { AddJobButton() }
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("Hello, World")
        }
    }
}

@Composable
fun AddJobButton() {
    FloatingActionButton(
        onClick = {},
    ) {
        Icon(Icons.Default.Add, contentDescription = stringResource(R.string.position_add))
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
