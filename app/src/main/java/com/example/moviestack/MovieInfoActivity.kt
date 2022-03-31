package com.example.moviestack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MovieInfoActivity : AppCompatActivity() {

    var movieName: String = ""
    var movieDescription: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_info)

        movieName = intent.getStringExtra("MOVIE_NAME").toString()
        movieDescription = intent.getStringExtra("MOVIE_DESCRIPTION").toString()
        updateMovieName()
    }

    fun updateMovieName(){
        findViewById<TextView>(R.id.movieName).text = movieName
        findViewById<TextView>(R.id.movieDescription).text = movieDescription
    }
}