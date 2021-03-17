package com.banshion.fragmentbestpracticekotlin


/**
 * String 扩展函数
 */
fun String.letterCount(): Int {
    var count = 0
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

