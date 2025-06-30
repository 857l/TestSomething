package ru.n857l.testsomething

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

interface SecondsToHours {

    fun map(value: Long): String

    class Base : SecondsToHours {

        private val simpleDateFormat = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)

        override fun map(value: Long): String {
            val date = Date(value)
            return simpleDateFormat.format(date)
        }

    }
}