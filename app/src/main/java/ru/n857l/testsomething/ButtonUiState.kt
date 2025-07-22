package ru.n857l.testsomething

import ru.n857l.testsomething.views.UpdateChoiceButton
import java.io.Serializable

interface ButtonUiState : Serializable {

    fun update(update: UpdateChoiceButton)

    abstract class Abstract(
        private val value: String,
        private val color: String,
        private val clickable: Boolean,
        private val enable: Boolean
    ) : ButtonUiState {

        override fun update(update: UpdateChoiceButton) {
            update.update(value)
            update.update(color, clickable, enable)
        }

    }

}