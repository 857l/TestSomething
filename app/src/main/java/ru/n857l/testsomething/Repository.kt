package ru.n857l.testsomething

class Repository {

    private var email: String = ""

    fun save(email: String){
        this.email = email
    }

    fun restore() = email

}