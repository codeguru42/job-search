package codeguru.jobsearch.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import codeguru.jobsearch.R

@Composable
fun JobListScreen(modifier: Modifier, onClickAddJob: () -> Unit) {
    Scaffold (
        modifier = modifier,
        floatingActionButton = { AddJobButton(onClickAddJob) }
    ) {innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text("Hello, World")
        }
    }
}

@Composable
fun AddJobButton(onClickAddJob: () -> Unit) {
    FloatingActionButton(
        onClick = onClickAddJob,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
    ) {
        Icon(Icons.Default.Add, contentDescription = stringResource(R.string.position_add))
    }
}
