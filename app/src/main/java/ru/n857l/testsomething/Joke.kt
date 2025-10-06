package ru.n857l.testsomething

class Joke(
    private val text: String,
    private val punchLine: String
) {

    fun toUi() = "$text\n$punchLine"
}