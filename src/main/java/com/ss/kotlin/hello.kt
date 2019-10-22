package com.ss.kotlin

/**
 * hello
 *
 * @author  shisong
 * @date 2019/9/10
 */
fun main(args: Array<String>){
    println("hello,world,$args[0]")
    println(args)
    Greeter("bbb0").greet()
}

class Greeter(val name: String){
    fun greet(){
        println("Hello, $name")
    }
}