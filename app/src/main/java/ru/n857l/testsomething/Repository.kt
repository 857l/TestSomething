package ru.n857l.testsomething

import android.content.Context

class Repository(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("main", Context.MODE_PRIVATE)

    private var time: Long = 0

    fun time(): Long {
        return sharedPreferences.getLong(KEY, 0)
    }

    fun startTracking() {
        time = System.currentTimeMillis()
    }

    fun stopTracking() {
        val now = System.currentTimeMillis()
        val difference = now - time
        val saved = sharedPreferences.getLong(KEY, 0)
        val new = saved + difference
        sharedPreferences.edit().putLong(KEY, new).apply()
    }

    companion object {
        private const val KEY = "time_key"
    }

}