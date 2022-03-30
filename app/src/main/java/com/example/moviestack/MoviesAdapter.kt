package com.example.moviestack

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MoviesAdapter(private val ctx: Context, private val layout: Int, private val data: List<MoviesNames>):

    ArrayAdapter<MoviesNames>(ctx, layout, data){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Para realizar el filtro de películas en el listView
        val layoutInflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(layout, null)
        val name = view.findViewById<TextView>(R.id.movieName)
        name.text = data[position].name
        val desc = view.findViewById<TextView>(R.id.movieDescription)
        desc.text = data[position].description
        val image = view.findViewById<ImageView>(R.id.movieImage)
        val id = ctx.resources.getIdentifier(data[position].name.lowercase(), "drawable", ctx.packageName)
        image.setImageResource(id)
        return view
    }

}