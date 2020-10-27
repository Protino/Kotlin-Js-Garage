package external.firebase

/**
 * Created by Gurupad Mamadapur on 14/04/20
 */
data class FirebaseOptions(
    @JsName("apiKey") val apiKey: String,
    @JsName("appId") val applicationId: String,
    @JsName("databaseURL") val databaseUrl: String?,
    @JsName("messagingSenderId") val gcmSenderId: String?,
    @JsName("projectId") val projectId: String?,
    @JsName("storageBucket") val storageBucket: String?,
    @JsName("authDomain") val authDomain: String?,
    @JsName("measurementId") val measurementId: String?
    // add others if any
)
