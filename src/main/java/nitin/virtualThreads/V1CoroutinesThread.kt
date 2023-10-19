package nitin.virtualThreads
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args : Array<String>) = runBlocking {
    launch { task11() }
    launch { task21() }

    println("DONE in : Main thread ${Thread.currentThread()}")
}
suspend fun task11(){
    val x = 90
    println("entering task1 ${Thread.currentThread()}")
    delay(2000)
    println("exiting task1 ${Thread.currentThread()} - Value of x = $x")
}

suspend fun task21(){
    println("entering task2 ${Thread.currentThread()}")
    delay(1000)
    println("exiting task2 ${Thread.currentThread()}")

}