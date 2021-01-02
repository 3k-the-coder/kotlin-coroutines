package coroutineCancellation

/*
    Coroutine is cancelled in following scenarios,
    1. Coroutine is taking too long to respond
    2. You no longer need the result from the coroutine, etc

    To cancel a CR it needs to cooperative

    .cancel() -> would cancel the coroutine if it is cooperative
    .join() -> waits for the completion of execution

    .cancel & .join are used in conjunction therefore we have another function which combines the properties of
    both
    ".cancelAndJoin()"

    // There are two ways to make the coroutine cooperative
    1. Periodically run a suspend function that checks for cancellation
 */