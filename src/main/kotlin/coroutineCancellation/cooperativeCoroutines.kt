package coroutineCancellation

// Method 1: In order to make a coroutine cancellable you should add any of the
// suspending functions defined in kotlinx.coroutines

// all the cancellable suspending functions will throw CancelledException on coroutine cancellation

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main starts ${Thread.currentThread().name}")

    val job = launch {
        for(i in 0..500){
            print("$i.")
            // delay(50)
            // the best way of making a coroutine cooperative is to use yield function
            yield()
        }
    }
    delay(200)
//    job.cancel()
//    job.join()

    job.cancelAndJoin()
    println("\nMain ends ${Thread.currentThread().name}")
}