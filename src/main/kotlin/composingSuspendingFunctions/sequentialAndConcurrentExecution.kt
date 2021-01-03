package composingSuspendingFunctions

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// by default inside the coroutine suspend functions are called sequentially.

// in order to make the execution concurrent you have to use either async or launch
// in this case we wanted the function to return some value, therefore we used async
// launch will also make the code execute concurrently but it can't return values

fun main() = runBlocking {
    println("In coroutineScope.main start ${Thread.currentThread().name}")

    val sequencialTime  = measureTimeMillis {
        val msgOne = getMessageOne()
        val msgTwo = getMessageTwo()

        println("$msgOne $msgTwo")
    }
    println("Sequential time taken is: ${sequencialTime}")


    val concurrentTime  = measureTimeMillis {
        val msgOne = async { getMessageOne() }
        val msgTwo = async{ getMessageTwo() }

        println("${msgOne.await()} ${msgTwo.await()}")
    }
    println("Concurrent time taken is: ${concurrentTime}")



    println("In coroutineScope.main end ${Thread.currentThread().name}")
}

suspend fun getMessageOne(): String {
    delay(1000L)
    return "Hello"
}

suspend fun getMessageTwo(): String {
    delay(1000L)
    return "world!"
}