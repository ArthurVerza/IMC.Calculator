package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val  tvResult = findViewById<TextView>(R.id.textview_result)
        val  tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("Extra_Result", 0.1f)

        tvResult.text = result.toString()

        val classificacao = if (result < 18.5f){
            "Abaixo do peso"
        } else if (result in 18.5f..24.99f) {
            "Normal"
        } else if (result in 25f..29.9f){
            "Sobrepeso"
        } else if (result in 30f..39.9f){
            "Obesidade II"
        } else {
            "Obesidade Grave"
        }


        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}