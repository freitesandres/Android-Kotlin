package com.freites.superandroidmaster.sintaxis.todoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.freites.superandroidmaster.R

class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)

        initComponent()
        initIUI()
    }

    private fun initIUI() {
        TODO("Not yet implemented")
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
    }
}