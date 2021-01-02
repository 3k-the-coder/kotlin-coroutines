package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

// coroutines.main thread and the background threads work independently
// application will be closed only after all the background threads have completed their execution

// but in case of coroutines, the application by default will not wait for a coroutine to finish its execution

fun main() {
    println("Running on ${Thread.currentThread().name}")


    thread { // used to create a background thread (worker thread)
        println("Thread Fake work start ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Thread Fake work end ${Thread.currentThread().name}")
    }

    GlobalScope.launch { // creates a background coroutine that runs on a background thread
        println("Coroutine Fake work start ${Thread.currentThread().name}")
        Thread.sleep(1000)

        /*
            We shouldn't use Thread.sleep in coroutine as it will block the entire thread, thus
            not allowing any other coroutines defined in the thread to work.
            the alternative for Thread.sleep in this case is "delay" which also takes time in terms of milliseconds
         */

        /*
            if you call delay then it might be possible that the subsequent statements executing in some other threads

            delay function can't be called outside a coroutine
         */
        println("Coroutine Fake work end ${Thread.currentThread().name}")
    }



    Thread.sleep(2000) // a dummy way to make our application wait for coroutines, not preferred in practice
    println("Running on ${Thread.currentThread().name}")
}

