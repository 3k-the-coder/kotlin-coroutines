package coroutineBuilders

// runBlocking coroutine builder blocks the current thread in which it operates
// where as launch and async would never block the thread

// The main purpose of using runBlocKing is to write tests for suspend functions