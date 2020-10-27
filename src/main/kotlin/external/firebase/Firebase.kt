@file:JsModule("firebase/app")
@file:JsNonModule
@file:Suppress(
    "INTERFACE_WITH_SUPERCLASS",
    "OVERRIDING_FINAL_MEMBER",
    "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
    "CONFLICTING_OVERLOADS",
    "EXTERNAL_DELEGATION"
)

package external.firebase

import external.firebase.analytics.Analytics
import external.firebase.messaging.Messaging

external interface Observer<T, E> {
    var next: NextFn<T>
    var error: ErrorFn<E>
    var complete: CompleteFn
}

external interface FirebaseApp {

    fun messaging(): Messaging
    fun analytics(): Analytics

    // Define other modules that are required

    var name: String
    var options: Any
}

external fun initializeApp(options: FirebaseOptions, name: String? = definedExternally): FirebaseApp