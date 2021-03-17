package com.banshion.providertest

import kotlin.reflect.KProperty

fun main() {
    val myClass = MyClass()
    val param = myClass.method(123)
    println(param)
}

class MyClass{
    fun <T> method(param: T): T {
        return param
    }
    var p by Delegate()
}

class MySet<T>(private val helperSet: HashSet<T>) : Set<T> by helperSet{
    fun helloWorld() = println("Hello World")

    override fun isEmpty() = false

}

class Delegate {

    var propValue: Any? = null

    /**
     * 这里写成MyClass表示仅可在MyClass类中使用；
     * 第二个参数KProperty<*>是Kotlin中的一个属性操作类，可用于获取各种属性相关的值，在当前场景下用不着，但是必须在方法参数上进行声明。
     * 另外，<*>这种泛型的写法表示你不知道或者不关心泛型的具体类型，只是为了通过语法编译而已，有点类似于Java中<?>的写法。
     */
    operator fun getValue(myClass: MyClass, prop: KProperty<*>): Any? {
        return propValue
    }

   operator fun setValue(myClass: MyClass, prop: KProperty<*>, value: Any?) {
        propValue = value
    }

}