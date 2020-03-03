package com.example.moviesmvp.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T, reified R> T.loadJson(file: String): R {
    val resource = T::class.java.classLoader?.getResourceAsStream("json/$file")?.bufferedReader()?.use { it.readText() }
    val type = object : TypeToken<R>(){}.type
    return Gson().fromJson(resource, type)
}