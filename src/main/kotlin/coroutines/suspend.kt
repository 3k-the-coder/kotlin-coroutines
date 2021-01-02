package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// a function with "suspend" modifier is called suspending functions

// suspending functions are only allowed to be called from a coroutine or from another suspending function

// They can't be called from outside coroutine
// if you wan't to call delay outside the coroutine then enclose that within runBlocking lambda expression

fun  main() {
    GlobalScope.launch { // creates a background coroutine that runs on a background thread
        println("Coroutine Fake work start ${Thread.currentThread().name}")
        delay(1000)
        println("Coroutine Fake work end ${Thread.currentThread().name}")
    }

    runBlocking {  // creates a coroutine that blocks the current main thread
        delay(1000) // waits for coroutine to finish
    }


    println("In main")





}