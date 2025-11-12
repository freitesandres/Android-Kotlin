package com.freites.superandroidmaster.sintaxis.imccalucalator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.freites.superandroidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import android.content.Intent
import android.widget.Toast

class imcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private var currentWeight: Int = 70

    private var currentAge: Int = 30

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    private lateinit var tvHeight: TextView

    private lateinit var rsHeight: RangeSlider

    private lateinit var btnSubtractWeight: FloatingActionButton

    private lateinit var btnPlusWeight: FloatingActionButton

    private lateinit var btnSubtractAge: FloatingActionButton

    private lateinit var btnPlusAge: FloatingActionButton

    private lateinit var tvWeight: TextView
    private lateinit var tvAge: TextView

    private lateinit var btnCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)

        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        tvWeight = findViewById(R.id.tvWeight)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            val height = value.toInt()
            tvHeight.text = "$height cm"


        }
        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()

        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            calculateIMC()
        }
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun calculateIMC() {
        // Altura en metros (tomada del RangeSlider)
        val heightInMeters = rsHeight.values.first() / 100f   // usa .first() en vez de [0]

        // Cálculo del IMC en float para evitar división entera
        val imc = currentWeight.toFloat() / (heightInMeters * heightInMeters)


        val intent = Intent(this, ResultIMCActivity::class.java).apply {
            putExtra("EXTRA_BMI", imc)
            putExtra("EXTRA_HEIGHT_CM", (heightInMeters * 100).toInt())
            putExtra("EXTRA_WEIGHT_KG", currentWeight)
            putExtra("EXTRA_AGE", currentAge)
        }
        startActivity(intent)


        val resultText = when {
            imc < 18.5f -> "Bajo peso"
            imc < 25f -> "Normal"
            imc < 30f -> "Sobrepeso"
            else -> "Obesidad"
        }

        Toast.makeText(
            this,
            "Tu IMC es %.2f (%s)".format(imc, resultText),
            Toast.LENGTH_LONG
        ).show()
    }
}