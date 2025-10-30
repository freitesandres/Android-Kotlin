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

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnSaludApp.setOnClickListener { navigateToSaludApp() }
btnIMCApp.setOnClickListener { navigateToIMCApp() }
    }
     private fun navigateToSaludApp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)

    }
}

private fun MenuActivity.navigateToIMCApp() {
val intent = Intent (this, imcCalculatorActivity::class.java)
    startActivity(intent)
}
