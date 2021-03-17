package com.banshion.helloworld

class Student(val sno: String, val grade: Int,name: String, age: Int) : Person(name, age),Study {
    init {
        //由于主构造函数没有函数体 可以在这里写主构造函数的函数体
        println("sno is $sno")
        println("grade is $grade")
    }
    //次构造函数
    constructor(name: String, age: Int):this("",0,name,age) {}

    constructor() : this("", 0){

    }

    override fun readBook() {
        println("$name is reading.")

    }

    override fun doHomeWork() {
        println("$name is doing homework.")
    }

}