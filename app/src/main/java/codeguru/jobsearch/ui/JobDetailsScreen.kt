package codeguru.jobsearch.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import codeguru.jobsearch.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun JobDetailsScreen(modifier: Modifier) {
    val (title, setTitle) = remember {
        mutableStateOf("")
    }
    val (company, setCompany) = remember {
        mutableStateOf("")
    }
    Scaffold(
        floatingActionButton = { SaveJobButton(onClickSaveJob = {  }) }
    ) {
        Column(modifier = modifier) {
            TextField(
                value = title,
                onValueChange = setTitle,
                label = { Text(stringResource(id = R.string.title)) },
                singleLine = true
            )
            TextField(
                value = company,
                onValueChange = setCompany,
                label = { Text(stringResource(id = R.string.company)) },
                singleLine = true
            )
        }
    }
}

@Composable
fun SaveJobButton(onClickSaveJob: () -> Unit) {
    FloatingActionButton(
        onClick = onClickSaveJob,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
    ) {
        Icon(Icons.Default.Check, contentDescription = stringResource(R.string.position_save))
    }
}
