package com.example.moviestack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MovieInfoActivity : AppCompatActivity() {

    var movieName = "La tumba de las luciernágas"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_info)

        movieName = intent.getStringExtra("MOVIE_NAME").toString()
        updateMovieName()
    }

    fun updateMovieName(){
        findViewById<TextView>(R.id.movieName).text = movieName
    }
}