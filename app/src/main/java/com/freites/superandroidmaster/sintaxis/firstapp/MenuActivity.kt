package com.freites.superandroidmaster.sintaxis.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.freites.superandroidmaster.R
import com.freites.superandroidmaster.sintaxis.imccalucalator.imcCalculatorActivity
import com.freites.superandroidmaster.sintaxis.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnTODO.setOnClickListener { navigateToTodoApp() }
    }

    private fun navigateToSaludApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)

    }
}

private fun MenuActivity.navigateToTodoApp() {
    val intent = Intent(this, TodoActivity::class.java)
    startActivity(intent)
}

private fun MenuActivity.navigateToIMCApp() {
    val intent = Intent(this, imcCalculatorActivity::class.java)
    startActivity(intent)
}
