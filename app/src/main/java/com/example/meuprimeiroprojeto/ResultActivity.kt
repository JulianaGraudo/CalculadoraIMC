package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textView_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /*
       IMC 18,5 ou menos - abaixo do normal.
       IMC Entre 18,6 e 24,9 - peso normal
       IMC Entre 25,0 e 29,9 - sobrepeso.
       IMC Entre 30,0 e 34,9 - obesidade grau 1.
       IMC Entre 35,0 e 39,9 - obesidade grau 2.
       IMC Acima de 40,0 - obesidade grau 3
    */


        val classificacao = if (result <=18.5f){
            "ABAIXO DO NORMAL"
        } else if (result > 18.5f && result <25f) {
            "NORMAL"
        } else if (result >= 25f && result <30f){
            "SOBREPESO"
        } else if (result >= 30f && result <35f){
            "OBESIDADE GRAU 1"
        } else if (result >= 35f && result <40f){
            "OBESIDADE GRAU 2"
        } else {
            "OBESIDADE GRAU 3"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)

    }
}