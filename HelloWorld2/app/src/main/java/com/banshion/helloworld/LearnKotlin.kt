package com.banshion.helloworld

import kotlin.math.max

fun main() {
    var student = Student("001", 11, "Tom", 15)
    doStudy(student)
}
fun doStudy(student: Student) {
    student.readBook()
    student.doHomeWork()
}
fun largerNumber(num1: Int, num2: Int) = max(num1, num2)
fun largerNumber1(num1: Int, num2: Int) = if (num1 > num2) num1 else num2
fun getScore(name: String)= if ("Tom" == name)
        100
    else if ("Jim" == name)
        200
    else if ("Jack" == name)
        300
    else if ("Lily" == name)
        400
    else
        0
fun getScore1(name: String) = when (name) {
    "Tom" -> 86
    "Jim" -> 77
    "Jack" -> 95
    "Lily" -> 100
    else -> 0
}


