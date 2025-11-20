package com.freites.superandroidmaster.sintaxis.superheroapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.freites.superandroidmaster.databinding.ActivitySuperHeroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
         retrofit=getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            private fun searchByName(query: String?) {

                CoroutineScope(Dispatchers.IO).launch {
                    val myResponse = retrofit.create(ApiService::class.java).getSuperheroes(query)
                    if (myResponse.isSuccessful){
                        Log.i("Andres", "funciona :)")
                    }else{
                        Log.i("Andres", "No funciona:(")
                    }
                }
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        }
        )
    }
    private fun getRetrofit(): Retrofit{
        return  Retrofit
            . Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}