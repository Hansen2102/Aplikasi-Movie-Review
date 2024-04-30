package com.hansen.moviereview

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class DetailActivity:AppCompatActivity() {

    companion object {
        const val key_movie = "key_movie"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataMovie = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Movie>(key_movie, Movie::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Movie>(key_movie)
        }
        if (dataMovie != null) {
            val tvDetailName:TextView = findViewById(R.id.tv_detail_name)
            val tvDetailDescription:TextView = findViewById(R.id.tv_detail_description)
            val ivDetailPhoto:ImageView = findViewById(R.id.iv_detail_photo)

            tvDetailName.text = dataMovie.name
            tvDetailDescription.text = dataMovie.description
            ivDetailPhoto.setImageResource(dataMovie.photo)
        }
    }
}