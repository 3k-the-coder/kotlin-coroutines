package coroutineScope

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// each coroutine has its coroutineScope instance attached to it


fun main() = runBlocking {
    println("Main ${this}")

    async {
        println("Async $this")
    }

    launch{
        println("Launch $this")
    }
}