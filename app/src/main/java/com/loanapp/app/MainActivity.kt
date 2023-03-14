package com.loanapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.loanapp.app.ui.theme.LoanApp_v3Theme
import com.loanapp.app.utils.Utils.convertStringToDate
import com.loanapp.app.viewmodels.LoanViewModel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {

    lateinit var viewModel: LoanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel = viewModel()
            LoanApp_v3Theme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeContainer(viewModel)
                }
            }
        }
    }
}

@Composable
fun HomeContainer(viewModel: LoanViewModel) {
    Column {
        AppBarView()
        HomeDataContainer(viewModel)

    }
}

@Composable
fun AppBarView(){
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text("I'm a TopAppBar")
        },
        backgroundColor =  MaterialTheme.colors.primarySurface,
        navigationIcon = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.ArrowBack, null)
            }
        }, actions = {
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Share, null)
            }
            IconButton(onClick = {/* Do Something*/ }) {
                Icon(Icons.Filled.Settings, null)
            }
        })
}

@Composable
fun HomeDataContainer(viewModel: LoanViewModel){
    Column(modifier = Modifier.fillMaxSize()) {

        Text("Hello World") //TODO should be a main list of views

        val listLoans = viewModel.loanDataList

        listLoans.forEach { item ->
            LoanElementView(item.title, item.sum, item.date)
        }



    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoanApp_v3Theme {
        HomeContainer(LoanViewModel())
    }
}

