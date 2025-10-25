package com.freites.superandroidmaster.sintaxis

fun main(){
    ifMultipleOR()
}
fun ifMultipleOR(){
    var pet ="cat"
    var isHappy = true

    if (pet == "dog" || (pet == "cat" && isHappy)){
        println("Es un gato o un perro")

    }
}
fun ifMultiple (){
    var age  = 18
    var parentPermission = false
    var imHappy = true

    if (age >= 18 && parentPermission && imHappy){
      println("Puedo fumar hierba")

    }
}
fun ifInt(){
    var age = 25

    if (age >= 25){
        println("Fumar hierba")
    }else{
        println("Fumar papelito")
    }
}
fun ifBoolean(){
    var soyFeliz: Boolean = false

    // sin nada == true
    // con ! al principio == false

    if (!soyFeliz ){
print("Estoy triste:(")
    }
}
fun ifAnidado(){
    val animal = "oso"

    if (animal == "dog"){
        println("Es un perro!!")
}else if(animal == "cat"){
       println("Es un gato")
}else if(animal == "conejo"){
        println("Es un conejo")
    }else{
        println("El animal no coincide")
    }



}

fun IfBasico(){
    val name = "Mellamooandres"
    if (name== "Mellamooandres"){
        println("oye, la variable name es Mellamooandres")
    }else{
    println("Este no es Mellamooandres")
    }
}