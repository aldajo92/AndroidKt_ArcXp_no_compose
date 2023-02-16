package com.example.arcxpcodechallenge

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

fun <T> String.createObjectFromStringJson(type: Class<T>) =
    Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .adapter(type)
        .fromJson(this) as T

fun <T> getObjectFromResourcesPath(resourceFilePath: String, type: Class<T>) =
    getJsonStringFromResources(resourceFilePath, type).createObjectFromStringJson(type)

fun getJsonStringFromResources(fileName: String?, javaClass: Class<*>): String {
    if (!fileName.isNullOrEmpty()) {
        var inputStream: InputStream? = null
        try {
            inputStream = javaClass.classLoader?.getResourceAsStream(fileName)
            val builder = StringBuilder()
            val reader = BufferedReader(InputStreamReader(inputStream))

            var str = reader.readLine()
            while (str != null) {
                builder.append(str)
                str = reader.readLine()
            }
            return builder.toString()
        } finally {
            inputStream?.close()
        }
    } else return ""
}
