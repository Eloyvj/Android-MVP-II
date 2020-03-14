package com.example.moviesmvp.utils

import androidx.test.platform.app.InstrumentationRegistry
import java.io.IOException

fun String.loadResponse(featurePath: String = ""): String {
    try {
        val pathFormatted = if(featurePath.isNotEmpty()) "$featurePath/" else featurePath
        val stream = InstrumentationRegistry.getInstrumentation()
            .context
            .resources
            .assets
            .open("mockresponses/$pathFormatted$this")

        val size = stream.available()
        val buffer = ByteArray(size)
        stream.read(buffer)
        stream.close()
        return String(buffer)
    } catch (e: IOException) {
        throw e
    }
}