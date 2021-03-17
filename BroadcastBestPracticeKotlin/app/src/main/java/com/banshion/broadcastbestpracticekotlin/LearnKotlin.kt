package com.banshion.broadcastbestpracticekotlin

import java.lang.StringBuilder

fun main() {
    val num1AndNum2 = num1AndNum2(1, 2, ::minus)
    //Lambda表达式中的最后一行代码会自动作为返回值
    val num1AndNum21 = num1AndNum2(1, 2) { n1, n2 ->
        n1 - n2
    }
    var list = listOf<String>("Apple", "Banana", "Orange", "Pear", "Grape")
    val result=StringBuilder().hufei {
        append("Start eating fruits.\n")
        for (s in list) {
            append(s).append("\n")
        }
        append("Ate all fruits.")
    }

    println("main start")
    val str = ""
    printString(str){s ->
        println("lambda start")
        if(s.isEmpty()) return
        println(s)
        println("lambda end")
    }
    println("main end")
}

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

/**
 * 这里我们给StringBuilder类定义了一个build扩展函数，这个扩展函数接收一个函数类型参数，并且返回值类型也是StringBuilder。
 * StringBuilder.() 在函数类型的前面加上ClassName. 就表示这个函数类型是定义在哪个类当中的。
 * 那么这里将函数类型定义到StringBuilder类当中有什么好处呢？
 * 好处就是当我们调用build函数时传入的Lambda表达式将会自动拥有StringBuilder的上下文，同时这也是apply函数的实现方式。
 */

fun StringBuilder.hufei(block:StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

/**
 * 内联函数不会每调一次Lambda表达式就创建一次对象
 */
inline fun inlineText(block1: () -> Unit, noinline block2: () -> Unit) {

}

inline fun printString(str: String, block: (String) -> Unit) {
    println("printString begin")
    block(str)
    println("printString end")
}

inline fun runRunnable(crossinline block: () -> Unit) {
    val runnable= Runnable{
        block()
    }
    runnable.run()
}
