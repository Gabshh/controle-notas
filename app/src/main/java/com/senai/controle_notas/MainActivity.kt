package com.senai.controle_notas

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

lateinit var nota1EditText: EditText
lateinit var nota2EditText: EditText
private lateinit var nomeEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener {
            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)
            nomeEditText = findViewById(R.id.nome)
            val nomeEditText = findViewById<EditText>(R.id.nome)
            val resultadoTextView = findViewById<TextView>(R.id.resultado)

            if (validarCampos()) {
                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()
                val nome = nomeEditText.text.toString()
                val resultado = resultadoTextView.text.toString().toInt()

                val media = calcularMedia(nota1, nota2)

//                resultadoTextView.text = situacaoAluno(media)
                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("nome", nome)
                intent.putExtra("nota1", nota1)
                intent.putExtra("nota2", nota2)
                intent.putExtra("media", media)
                intent.putExtra("siituacao", situacaoAluno(media))
                startActivity(intent)

            }

        }

        sair.setOnClickListener {
            finish()
        }

    }

    private fun situacaoAluno(media: Int): String {
        if (media >= 5) {
            return "Aprovado"
        }else{
            return "Reprovado"
        }

    }

    //fznd umas poha q da a msm coisa

    //    private fun calcularMedia(nota1: Int, nota2: Int): Double {
//        return (nota1 + nota2) / 2
//    }

//    private fun calcularMedia(nota1: Int, nota2: Int): Double = (nota1 + nota2) / 2.0

//    val calcularMedia = {nota1: Int, nota2: Int -> (nota1 + nota2) / 2}

    fun calcularMedia (vararg notas: Int): Int{
        var soma = 0
        for (nota in notas) {
            soma = soma + nota
        }
        return soma / notas.size
    }

    private fun validarCampos(): Boolean {
        var noError = true
        if (nota1EditText.text.isBlank()) {
            nota1EditText.setError("Digite a nota 1")
            noError = false
        }
        if (nota2EditText.text.isBlank()){
            nota2EditText.setError("Digite a nota 2")
            noError = false
        }
        if (nomeEditText.text.isBlank()){
            nomeEditText.setError("Digite o nome do aluno!")
            noError = false
        }

        return noError
    }
}