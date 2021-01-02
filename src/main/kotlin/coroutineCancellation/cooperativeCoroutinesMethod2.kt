package coroutineCancellation

import kotlinx.coroutines.*

/*
    Method 2
    we can make use a boolean property, isActive to activate or cancel the coroutine

 */

fun main() = runBlocking {
    println("Main starts ${Thread.currentThread().name}")

    val job = launch(Dispatchers.Default) {
        for(i in 0..500){
            if(!isActive)
                return@launch
            print("$i.")
            Thread.sleep(1)
        }
    }
    delay(3)

    job.cancelAndJoin()
    println("\nMain ends ${Thread.currentThread().name}")
}