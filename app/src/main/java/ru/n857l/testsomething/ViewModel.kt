package ru.n857l.testsomething

class ViewModel(private val repository: Repository) : Observe {

    private var callback: UiStateCallback = UiStateCallback.Base()

    fun login(email: String) {

        val valid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

        if (valid) {
            this.callback.postSuccess()
        } else {
            this.callback.postError("wrong email")
        }
    }

    fun clearEmail(input: String){
        repository.save(input)
        callback.postSuccess()
    }

    override fun observe(callback: UiStateCallback) {
        this.callback = callback
    }

    fun clear() {
        callback = UiStateCallback.Base()
    }

    fun init(firstTime: Boolean){
        if (!firstTime) {
            this.callback.postEmail(repository.restore())
        }
    }

}

interface Observe {
    fun observe(callback: UiStateCallback)
}

interface UiStateCallback {
    fun postEmail(value: String)
    fun postSuccess()
    fun postError(message: String)

    class Base : UiStateCallback {
        override fun postEmail(value: String) = Unit

        override fun postSuccess() = Unit

        override fun postError(message: String) = Unit

    }
}