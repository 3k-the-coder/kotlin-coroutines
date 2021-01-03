package coroutineContext

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// each coroutine has its own coroutine scope
// unlike coroutine scope which is unique for each coroutine
// coroutine context can be inherited from parent to child

// each CR context has two major components , i.e. dispatcher and job objects
// dispatcher is very important and decides the thread of the coroutine
//  job is something which is returned by the coroutine and is used to control the working of the coroutine

// using coroutineContext you can access context of current coroutine
fun main() = runBlocking {

    // when you define a coroutine without any parameter,  then it will inherit the context of its immmediate
    // parent
    // even after delay or any suspending function the code will run on the same thread
    launch {
        println("C1 ${Thread.currentThread().name}")
    }

    // with parameters Dispatchers.Default [similar to GlobalScope.launch]
    // will operate on a separate background thread
    // after calling a delay or any other suspend function, the thread of operation may change
    launch(Dispatchers.Default) {
        println("C2 ${Thread.currentThread().name}")
        delay(100L)
        println("C2 after delay ${Thread.currentThread().name}")
    }

    // with parameters Dispatchers.Unconfined
    // will operate on the parent thread
    // after calling a delay or any other suspend function, the thread of operation may change
    launch(Dispatchers.Unconfined) {
        println("C3 ${Thread.currentThread().name}")
        delay(100L)
        println("C3 after delay ${Thread.currentThread().name}")
    }
    println("$this")

}