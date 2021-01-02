package coroutineBuilders

/*
    coroutine builders are the functions using which we build coroutines
    1. launch
    2. async
    3. runBlocking

    // Use of GlobalScope
    * if you use, just .launch it would create a coroutine in the local scope
    * if you use GlobalScope.launch then the coroutines would be created in global scope and are accessible
      throughout the lifespan of app.
    * GlobalScope is not preferred because if you forget about it or lost the reference then it would consume
    * a lot of memory


    // Difference between launch and async
    * launch will run the coroutine in the scope of the immediate parent coroutine
    *
 */