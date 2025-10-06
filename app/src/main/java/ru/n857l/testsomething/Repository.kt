package ru.n857l.testsomething

interface Repository<S, E> {

    fun init(resultCallBack: ResultCallback<S, E>)

    fun fetch()

    fun clear()
}

interface ResultCallback<S, E> {

    fun provideSuccess(data: S)

    fun provideError(error: E)
}