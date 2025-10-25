package com.freites.superandroidmaster.sintaxis

fun main() {
    var name: String = "Andres"
    var name1: String = "Andres"
    var name2: String = "Andres"
    var name3: String = "Andres"

    val weekDays = arrayOf("lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    println(weekDays.size)

    if (weekDays.size >= 8) {
        println(weekDays[7])
    } else {
        //println("No hay mas valores en el Array")
    }
//Modificar valores
    weekDays[0] = "Hi"
    //println(weekDays[0])

    // Bucles para Arrays
    for (position in weekDays.indices) {
        //println(weekDays[position])
    }
    for ((position, value) in weekDays.withIndex()) {
        println("la posicion $position, contiene $value")
    }
    for (weekDay in weekDays) {
        println("Now is $weekDay")
    }
}

