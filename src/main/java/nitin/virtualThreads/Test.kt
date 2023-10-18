package nitin.virtualThreads

fun task1(){
    println("entering task1 ${Thread.currentThread()}")
    println("entering task1 ${Thread.currentThread()}")
}

fun task2(){
    println("entering task2 ${Thread.currentThread()}")
    println("entering task2 ${Thread.currentThread()}")

}

fun main(args : Array<String>) {
    task1()
    task2()

    println("Main thread ${Thread.currentThread()}")

}