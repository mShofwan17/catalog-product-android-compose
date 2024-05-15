package me.test.data.dataSource

import android.util.Log

open class BaseDateSource {
    suspend fun <T> validateResponse(
        onSuccess: suspend () -> T,
    ): T {
        return try {
            onSuccess()
        } catch (e: Exception) {
            Log.i("TAG_Exception", "validateResponse: ${e.message}")
            throw Exception(e)
        }
    }
}