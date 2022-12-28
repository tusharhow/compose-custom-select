package com.example.composecustomselection

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.example.composecustomselection.ui.theme.ComposeCustomSelectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCustomSelectionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    verticalSelect()
                }
            }
        }
    }
}

@Composable
fun verticalSelect() {
    val listState = rememberLazyListState()
    val selectedIndex = remember {
        mutableStateOf(0) // default selected index
       }
    LazyColumn(state = listState) {
        items(21) {
           Card ( modifier = Modifier.fillMaxWidth().height(65.dp)
               .padding(5.dp)
               .clickable {
                   selectedIndex.value = it
                    println(selectedIndex.value)
               },
               backgroundColor = if (selectedIndex.value == it) Red else Gray,
               elevation = 8.dp
           ) {
               Column(

                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center
               ) {
                   Text(
                       text = "Item $it",
                       style = TextStyle(
                           fontWeight = FontWeight.Bold,
                           fontSize = 20.sp,
                            color = White
                       )
                   )
               }


           }
            Divider()
        }
    }
}