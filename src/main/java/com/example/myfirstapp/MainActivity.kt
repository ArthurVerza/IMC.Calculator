package com.example.myfirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btncalculate: Button = findViewById(R.id.btncalculate)
        val edtweight: EditText = findViewById(R.id.editweight)
        val edtheight: EditText = findViewById(R.id.editheight)


        btncalculate.setOnClickListener {

            val alturastr = edtheight.text.toString()
            val pesostr = edtweight.text.toString()

            if (alturastr.isNotEmpty() && pesostr.isNotEmpty()) {

                val height: Float = edtheight.text.toString().toFloat()

                val heightfinal: Float = height * height
                val peso: Float = edtweight.text.toString().toFloat()
                val result = peso / heightfinal


                val intent = Intent(this, resultActivity::class.java)
                    .apply {
                        putExtra("Extra_Result", result)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Fill all the information", Toast.LENGTH_LONG).show()
            }


        }
    }
}