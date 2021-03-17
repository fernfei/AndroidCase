package com.banshion.activitytest

import java.lang.StringBuilder

fun main() {
    val list = listOf<String>("Apples", "Banana", "Orange", "Pear", "Grape")
    val builder = StringBuilder()
    builder.append("Start eating fruits \n")
    for (str in list) {
        builder.append(str).append("\n")
    }

    builder.append("Ate all fruits.")
    println(builder.toString())

    //with作为标准函数 StringBuilder被当作上下文对象传入，with最后一行作为返回值
    val result = with(StringBuilder()) {
        for (s in list) {
            append(s).append("\n")
        }
        toString()
    }
    println(result)

    //和with用法相似
    val runResult=StringBuilder().run {
        for (s in list) {
            append(s + "\n")
        }
        toString()
    }
    println(result)
    //和run用法极其相似唯一区别在于不用指定返回值，返回值是调用对象本身
    val applyResult=StringBuilder().apply {
        for (s in list) {
            append(s + "\n")
        }
    }
    println(result.toString())
}