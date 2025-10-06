package ru.n857l.testsomething

import android.app.Application

class App : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(
            FakeRepository(ManageResources.Base(this))
        )
    }
}