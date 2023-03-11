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
import com.loanapp.app.ui.theme.LoanApp_v3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoanApp_v3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeContainer("Android")
                }
            }
        }
    }
}

@Composable
fun HomeContainer(name: String) {
    Column {
        AppBarView()
        HomeDataContainer()

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
fun HomeDataContainer(){
    Card(modifier = Modifier.fillMaxSize()) {

        Text("Hello World") //TODO should be a main list of views

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoanApp_v3Theme {
        HomeContainer("Android")
    }
}