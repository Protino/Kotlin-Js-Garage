package external.firebase

typealias NextFn<T> = (value: T) -> Unit

typealias ErrorFn<E> = (error: E) -> Unit

typealias CompleteFn = () -> Unit

typealias Unsubscribe = () -> Unit

