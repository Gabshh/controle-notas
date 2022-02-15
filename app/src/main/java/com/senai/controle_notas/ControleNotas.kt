package com.senai.controle_notas

fun situacaoAluno(media: Int): String {
    if (media >= 5) {
        return "Aprovado"
    }else{
        return "Reprovado"
    }

}
fun calcularMedia (vararg notas: Int): Int{
    var soma = 0
    for (nota in notas) {
        soma = soma + nota
    }
    return soma / notas.size
}