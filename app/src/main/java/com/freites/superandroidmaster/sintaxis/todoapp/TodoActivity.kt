package com.freites.superandroidmaster.sintaxis.todoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freites.superandroidmaster.R

class TodoActivity : AppCompatActivity() {
private val categories = listOf(
    TaskCategory.Personal,
    TaskCategory.Business,
    TaskCategory.Other

)
    private val tasks = mutableListOf(
        Task("PruebaBusiness", TaskCategory.Business),
        Task("PruebaPersonal", TaskCategory.Personal),
        Task("PruebaOther", TaskCategory.Other)
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView

    private lateinit var taskAdapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)

        initComponent()
        initIUI()
    }

    private fun initIUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager (  this, LinearLayoutManager. HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter
        taskAdapter = TasksAdapter()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)

    }
}