package ru.n857l.testsomething

class MainViewModel(
    private val repository: Repository<Joke, Error>
) {

    private var textCallBack: TextCallBack = TextCallBack.Empty

    fun getJoke() {
        repository.fetch()
    }

    fun clear() {
        textCallBack = TextCallBack.Empty
        repository.clear()
    }

    fun init(textCallBack: TextCallBack) {
        this.textCallBack = textCallBack
        repository.init(object : ResultCallback<Joke, Error> {
            override fun provideSuccess(data: Joke) {
                textCallBack.provideText(data.toUi())
            }

            override fun provideError(error: Error) {
                textCallBack.provideText(error.message())
            }
        })
    }
}

interface TextCallBack {

    fun provideText(text: String) = Unit

    object Empty: TextCallBack
}