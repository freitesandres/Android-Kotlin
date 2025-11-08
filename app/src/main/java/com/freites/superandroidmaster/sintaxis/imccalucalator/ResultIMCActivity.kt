package com.freites.superandroidmaster.sintaxis.imccalucalator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.freites.superandroidmaster.R
import kotlin.math.round

class ResultIMCActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)

        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val cardResult = findViewById<CardView>(R.id.cardResult)
        val tvCategory = findViewById<TextView>(R.id.tvCategory)
        val tvBmi = findViewById<TextView>(R.id.tvBmi)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val btnRecalc = findViewById<Button>(R.id.btnRecalculate)

        val bmi = intent.getFloatExtra("EXTRA_BMI", 0f)
        val (category, descRes, colorRes) = mapBmiToUi(bmi)

        tvTitle.text = getString(R.string.your_result)
        tvCategory.text = category
        tvCategory.setTextColor(ContextCompat.getColor(this, colorRes))
        tvBmi.text = String.format("%.2f", bmi)
        tvDescription.text = getString(descRes)

        btnRecalc.setOnClickListener { finish() }
    }

    private fun mapBmiToUi(bmi: Float): Triple<String, Int, Int> {
        return when {
            bmi < 18.5f -> Triple(
                getString(R.string.underweight),
                R.string.desc_underweight,
                R.color.result_warn
            )
            bmi < 25f -> Triple(
                getString(R.string.normal),
                R.string.desc_normal,
                R.color.result_ok
            )
            bmi < 30f -> Triple(
                getString(R.string.overweight),
                R.string.desc_overweight,
                R.color.result_orange
            )
            else -> Triple(
                getString(R.string.obesity),
                R.string.desc_obesity,
                R.color.result_bad
            )
        }
    }
}