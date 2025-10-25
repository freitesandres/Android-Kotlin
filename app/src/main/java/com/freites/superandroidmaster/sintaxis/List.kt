package com.freites.superandroidmaster.sintaxis

fun main(){
    inmutableList ()
}
fun inmutableList (){

    val readOnly: List<String> = listOf("lunes", "Martes","Miercoles","Jueves","Viernes","Sabado","Domingo")

// println(readOnly.size)
//println(readOnly)
    //filtrar

    //val example = readOnly.filter { it.contains("a") }
    //println(example)

    readOnly.forEach {weakDay-> println(weakDay) }
}