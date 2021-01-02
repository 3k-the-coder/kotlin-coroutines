package coroutineCancellation

// all the suspending functions which are cancellable throw CancellationException

// therefore it is preferred to have them enclosed within try-catch

// can't execute suspending function from finally because the coroutine would already been cancelled by that time

// if you want to execute the the suspending function from finally then wrap the code within "withContext" function

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main starts ${Thread.currentThread().name}")

    val job = launch {
        try{
            for(i in 0..500){
                print("$i.")
                delay(50)
            }
        } catch(ex: CancellationException) {
            println("Exception caught peacefully")
        } finally {
            println("In finally")
        }

    }
    delay(200)

    job.cancelAndJoin()
    println("\nMain ends ${Thread.currentThread().name}")
}