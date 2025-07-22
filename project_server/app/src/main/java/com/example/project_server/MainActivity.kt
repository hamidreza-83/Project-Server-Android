package com.example.myapplication

import ads_mobile_sdk.h6
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val client = HttpClient() {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val scope = rememberCoroutineScope()
                val movies = remember { mutableStateListOf<Movie>() }
                val errorMessage = remember { mutableStateOf("") }
                val noMoviesMessage = remember { mutableStateOf("") }
                val isLoading = remember { mutableStateOf(false) }
                Column (
                    modifier = Modifier.fillMaxSize().padding(30.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(onClick ={
                        isLoading.value = true
                        scope.launch(Dispatchers.IO){
                            movies.clear()
                            delay(1000)
                            try {
                                val response = client.get("http://45.139.11.115:5852/api/collections/movie/records").body<MovieResponse>()
                                movies.addAll(response.items)
                            }catch (e:Exception){
                                errorMessage.value = "Can't Access To The Movies"
                                noMoviesMessage.value = ""
                            }finally {
                                isLoading.value = false
                                if (movies.isEmpty()){
                                    noMoviesMessage.value = "There is No Movie"
                                }else{
                                    noMoviesMessage.value = ""
                                }
                            }
                        }
                    }
                    ) {
                        Text("Click To Get Movies")
                    }
                    if (errorMessage.value.isNotEmpty()) {
                        Text(text = errorMessage.value, color = Color.Red)
                    }
                    if (noMoviesMessage.value.isNotEmpty()) {
                        Text(text = noMoviesMessage.value, color = Color.Red)
                    }
                    if (isLoading.value) {
                        CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                    }else{
                        LazyColumn {
                            val sortedMovies = movies.sortedBy { it.title }
                            items(sortedMovies) { movie ->
                                Box(
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .fillMaxWidth()
                                        .background(Color.LightGray)
                                        .padding(16.dp)
                                ) {
                                    Column {
                                        Text(text = "Movie Name: ${movie.title}")
                                        Text(text = "Director: ${movie.director}")
                                        Text(text = "Date: ${movie.time}")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

