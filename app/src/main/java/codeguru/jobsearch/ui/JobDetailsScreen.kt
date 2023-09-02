package codeguru.jobsearch.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import codeguru.jobsearch.R

@Composable
fun JobDetailsScreen(modifier: Modifier) {
    val (title, setTitle) = remember {
        mutableStateOf("")
    }
    val (company, setCompany) = remember {
        mutableStateOf("")
    }
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
