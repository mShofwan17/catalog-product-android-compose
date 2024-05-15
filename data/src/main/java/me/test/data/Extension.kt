package me.test.data

fun Int.isFavourite() : Boolean{
    return this == 1
}
fun Boolean.isFavourite(): Int{
    return if (this) 1 else 0
}