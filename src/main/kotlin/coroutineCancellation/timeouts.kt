package coroutineCancellation
import kotlinx.coroutines.*

// withTimeout and withTimeoutOrNull are two coroutine builders that are used to create timebound
// coroutines

//withTimeout will throw TimeoutCancellationException whereas withTimeoutOrNull doesn't throw any exception

fun main() = runBlocking {
    println("Main starts ${Thread.currentThread().name}")

    withTimeout(200) {
        try{
            for(i in 0..500) {
                print("$i.")
                delay(50)
            }
        } catch (ex: TimeoutCancellationException) {
            println("Exception caught peacefully")
        }


    }

    println("\nMain ends ${Thread.currentThread().name}")
}