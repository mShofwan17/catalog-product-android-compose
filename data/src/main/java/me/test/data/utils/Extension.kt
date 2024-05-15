package me.test.data.utils

fun Int.toUiFavourite(): Boolean {
    return this == 1
}

fun Boolean.toEntityFavourite(): Int {
    return if (this) 1 else 0
}