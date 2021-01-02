package coroutineBuilders

import kotlinx.coroutines.*

// launch is called fire and forget because it won't return to the place where it is called
// so if we want get a value from coroutine we can make use of async to build the coroutine
// async returns Deferred object that is a subclass of Job
// instead of using job.done as in the case of launch we can make use of job.await
// the concept is similar to the javascript futures and promises


fun main() = runBlocking {
    println("Main start ${Thread.currentThread().name}")

    val job: Deferred<String> = async {
        println("In coroutine ${Thread.currentThread().name}")
        delay(1000)
        println("Coroutine end ${Thread.currentThread().name}")

        "Kunal Kini"
    }


    val name = job.await()
    println("Main end -> $name ${Thread.currentThread().name}")
}