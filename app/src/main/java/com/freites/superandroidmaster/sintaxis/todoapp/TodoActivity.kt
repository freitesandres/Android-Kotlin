package com.freites.superandroidmaster.sintaxis.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freites.superandroidmaster.R
import com.freites.superandroidmaster.sintaxis.todoapp.TaskCategory.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {
private val categories = listOf(
    Personal,
    Business,
    Other

)
    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other)
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView

    private lateinit var taskAdapter: TasksAdapter
    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)

        initComponent()
        initIUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }
    private fun showDialog(){
val dialog = Dialog (this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when(selectedRadioButton.text){
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    else -> Other
                }
                tasks.add(Task(currentTask,currentCategory))
                updateTasks()
                dialog.hide()
            }

        }

        dialog.show()
    }
    private fun initIUI() {
        categoriesAdapter = CategoriesAdapter(categories) {updateCategories(it)}
        rvCategories.layoutManager = LinearLayoutManager (  this, LinearLayoutManager. HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter
        taskAdapter = TasksAdapter(tasks,{onItemSelected(it)})
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = taskAdapter
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)

    }

    private fun onItemSelected(position: Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()

    }
    private fun updateCategories(position: Int){
categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }
    private fun updateTasks(){
        val selectedCategories: List <TaskCategory> = categories.filter {it.isSelected}
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.tasks = newTasks
        taskAdapter.notifyDataSetChanged()
    }
}