package com.example.myapplication

import kotlinx.serialization.Serializable
import java.sql.Time
@Serializable
data class Movie(val title:String, val director:String, val time: String)
@Serializable
data class MovieResponse(val items:List<Movie>)


