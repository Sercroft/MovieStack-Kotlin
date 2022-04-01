package com.example.moviestack

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val moviesNames = arrayListOf<MoviesNames>(
        MoviesNames("La tumba de las luciernágas", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("The Batman", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("Avatar", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("El Padrino", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("Drive a Car", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("Guasón", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."),
        MoviesNames("El viaje de Chihiro", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MovieStack)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val search = findViewById<EditText>(R.id.search)
        val adapter = MoviesAdapter(this, R.layout.activity_movie_info, moviesNames)

        listView.adapter = adapter
        searchMovies(search, adapter)
        listView.setOnItemClickListener { parent, view, position, id ->
            // do something
            selectMovies(moviesNames[position].name, moviesNames[position].description)
            adapter.notifyDataSetChanged()
        }
    }

    private fun searchMovies(keyWord:EditText, adapter: MoviesAdapter){
        val adp = adapter
        try {
            keyWord.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

               override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    adp.filter.filter(s)
                }
            })
        }catch(e: Exception){
            Toast.makeText(this, "Search exception: "+e, Toast.LENGTH_SHORT).show()
            Log.i("Search", "Search Exception")
        }
    }

    fun selectMovies(movieName: String, movieDescription: String) {
        // open a second activity
        val goto = Intent(this, MovieInfoActivity::class.java)
        goto.putExtra("MOVIE_NAME", movieName)
        goto.putExtra("MOVIE_DESCRIPTION", movieDescription)
        startActivity(goto)
    }
}