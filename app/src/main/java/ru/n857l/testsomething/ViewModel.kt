package ru.n857l.testsomething

class ViewModel(private val repository: Repository) : Observe {

    fun login(email: String) {
        val valid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (valid) {
            this.callback.postSuccess()
        } else {
            this.callback.postError("wrong email")
        }
    }

    private var callback: UiStateCallback = UiStateCallback.Base()

    override fun observe(callback: UiStateCallback) {
        this.callback = callback
    }

    fun clear() {
        callback = UiStateCallback.Base()
    }

}

interface Observe {
    fun observe(callback: UiStateCallback)
}

interface UiStateCallback {
    fun postSuccess()
    fun postError(message: String)

    class Base : UiStateCallback {
        override fun postSuccess() = Unit

        override fun postError(message: String) = Unit

    }
}