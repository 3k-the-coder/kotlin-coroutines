package coroutineBuilders

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main start ${Thread.currentThread().name}")

    val job: Job = launch {
        println("In coroutine ${Thread.currentThread().name}")
        delay(1000)
        println("Coroutine end ${Thread.currentThread().name}")
    }

    // instead of hardcoding the time using delay function we can make use of job object returned by
    // launch
    job.join()
    println("Main end ${Thread.currentThread().name}")
}