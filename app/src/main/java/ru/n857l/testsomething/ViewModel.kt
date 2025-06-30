package ru.n857l.testsomething

class ViewModel(private val repository: Repository, private val secondsToHours: SecondsToHours) :
    Observe {

    private var callback: UiStateCallback = UiStateCallback.Base()

    override fun observe(callback: UiStateCallback) {
        this.callback = callback
    }

    fun clear() {
        callback = UiStateCallback.Base()
    }

    fun startTrackingTime() {
        callback.post(secondsToHours.map(repository.time()))
        repository.startTracking()
    }

    fun stopTrackingTime() {
        repository.stopTracking()
    }

}

interface Observe {
    fun observe(callback: UiStateCallback)
}

interface UiStateCallback {
    fun post(message: String)

    class Base : UiStateCallback {

        override fun post(message: String) = Unit

    }
}