package com.banshion.fragmentbestpracticekotlin

import java.lang.StringBuilder

fun main() {
    val a = "ABC123xyz!@#"
    println(a.letterCount())
    val money1 = Money(5)
    val money2 = Money(6)
    //money1 + money2换呗转换为money1.plus(money2)
    val money3 = money1 + 20
    println(money3.value)
    println("weqwr" * 4)
}

/**
 * 运算符重载
 * 具体解释 https://www.ituring.com.cn/book/tupubarticle/34655
 */
class Money(val value: Int) {
    operator fun plus(money: Money): Money {
        val sum = value + money.value
        return Money(sum)
    }
    operator fun plus(num: Int): Money {
        val sum = value + num
        return Money(sum)
    }
}

operator fun String.times(n: Int): String {
    val sb = StringBuilder()
    repeat(n){
        sb.append(this)
    }
    return sb.toString()
}

