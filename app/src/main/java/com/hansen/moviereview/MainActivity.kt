package com.hansen.moviereview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movie)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, About::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    @SuppressLint("Recycle")
    private fun getListHeroes(): ArrayList<Movie> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listMovie= ArrayList<Movie>()
        for (i in dataName.indices) {
            val movie = Movie(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovies.adapter = listMovieAdapter

        listMovieAdapter.setOnItemClickCallback(object : ListMovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Movie) {
                showSelectedHero(data)
            }
        })
    }
    private fun showSelectedHero(movie: Movie) {
        Toast.makeText(this, "Kamu memilih " + movie.name, Toast.LENGTH_SHORT).show()
    }
}