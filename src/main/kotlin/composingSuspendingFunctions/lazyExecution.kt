package composingSuspendingFunctions

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


// we can execute the coroutine only when it is being used in the application by lazily executing

fun main() = runBlocking {
    println("In main start ${Thread.currentThread().name}")

        val msgOne = async(start = CoroutineStart.LAZY) { getMsgOne() }
        val msgTwo = async(start = CoroutineStart.LAZY) { getMsgTwo() }

//        println("${msgOne.await()} ${msgTwo.await()}") // coroutine will not execute since it is not being used




    println("In main end ${Thread.currentThread().name}")
}

suspend fun getMsgOne(): String {
    delay(1000L)
    println("After getMsgOne")
    return "Hello"
}

suspend fun getMsgTwo(): String {
    delay(1000L)
    println("After getMsgTwo")
    return "world!"
}