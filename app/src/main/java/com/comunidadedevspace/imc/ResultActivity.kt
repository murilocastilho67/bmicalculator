package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"
class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC,0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val classificacao: String
        val corTexto: Int

        when {
            result <= 18.5f -> {
                classificacao = "Thinness"
                corTexto = R.color.magreza
            }
            result <= 24.9f -> {
                classificacao = "Normal"
                corTexto = R.color.normal
            }
            result <= 29.9f -> {
                classificacao = "Overweight"
                corTexto = R.color.sobrepeso
            }
            result <= 39.9f -> {
                classificacao = "Obesity"
                corTexto = R.color.obesidade
            }
            else -> {
                classificacao = "Severe Obesity\n"
                corTexto = R.color.obesidade_grave
            }
        }

        tvClassificacao.text = classificacao
        tvClassificacao.setTextColor(resources.getColor(corTexto, null))

        tvClassificacao.text = classificacao
    }
}