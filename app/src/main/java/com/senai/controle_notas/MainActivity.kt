package com.senai.controle_notas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener(){
            val nota1 = findViewById<EditText>(R.id.nota1).text.toString().toInt()
            val nota2 = findViewById<EditText>(R.id.nota2).text.toString().toInt()
            val faltas = findViewById<EditText>(R.id.faltas).text.toString().toInt()
            val resultado = findViewById<TextView>(R.id.resultado)
            resultado.text = ""

            val media = (nota1 + nota2) / 2

            if (media >= 5){
                resultado.text = "Nota 1: $nota1 \n" +
                        "Nota 2: $nota2 \n" +
                        "Faltas: $faltas \n" +
                        "Média: $media \n" +
                        "Situação: Aprovado! :)"
                resultado.setTextColor(Color.GREEN)
            } else {
                resultado.text = "Nota 1: $nota1 \n" +
                        "Nota 2: $nota2 \n" +
                        "Faltas: $faltas \n" +
                        "Média: $media \n" +
                        "Situação: Reprovado! :("
                resultado.setTextColor(Color.RED)
            }
        }

        sair.setOnClickListener(){
            finish()
        }

    }
}