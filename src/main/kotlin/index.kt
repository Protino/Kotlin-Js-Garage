import external.firebase.FirebaseApp
import external.firebase.FirebaseOptions
import external.firebase.initializeApp
import kotlinext.js.jsObject
import kotlinx.browser.window

/**
 * Created by Gurupad Mamadapur on 27/10/20
 */

lateinit var firebaseApp: FirebaseApp

fun main() {

    val options: FirebaseOptions = jsObject() // LoadProper, firebaseOptions instead

    firebaseApp = initializeApp(options).also {
        // Require all the modules necessary, only these will be loaded onto the firebaseApp and also in the final bundle
        kotlinext.js.require("firebase/messaging")
        kotlinext.js.require("firebase/analytics")
    }

    initMessaging()

    logEvents()
}

fun initMessaging() {
    if (window.navigator != undefined) {
        window.navigator.serviceWorker
            .register(
                "firebase-messaging-sw.js" // Make sure to have worker.js file
            )
            .then { worker ->
                console.log("Registration successful, scope is: ${worker.scope}")
                firebaseApp.messaging().useServiceWorker(worker)
            }.catch {
                console.log("Service worker registration failed, error:", it)
            }
    }

    firebaseApp.messaging().getToken().then {
        console.log(it)
    }
}

fun logEvents() {
    firebaseApp.analytics().logEvent("Nice")
}
