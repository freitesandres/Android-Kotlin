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
import com.freites.superandroidmaster.sintaxis.superheroapp.SuperHeroListActivity
import com.freites.superandroidmaster.sintaxis.todoapp.TodoActivity
import com.freites.superandroidmaster.sintaxis.settings.SettingsActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnSuperHero = findViewById<Button>(R.id.btnSuperHero)
        val btnSettings  = findViewById<Button>(R.id.btnSettings)

        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnTODO.setOnClickListener { navigateToTodoApp() }
        btnSuperHero.setOnClickListener { navigateToSuperHeroApp() }
        btnSettings.setOnClickListener { navigateToSettingsApp() }
    }

    private fun navigateToSaludApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)

    }
}

private fun MenuActivity.navigateToSuperHeroApp() {
    val intent = Intent(this, SuperHeroListActivity::class.java)
    startActivity(intent)
}

private fun MenuActivity.navigateToTodoApp() {
    val intent = Intent(this, TodoActivity::class.java)
    startActivity(intent)
}

private fun MenuActivity.navigateToIMCApp() {
    val intent = Intent(this, imcCalculatorActivity::class.java)
    startActivity(intent)
}
private fun MenuActivity.navigateToSettingsApp() {
    val intent = Intent(this, SettingsActivity::class.java)
    startActivity(intent)
}