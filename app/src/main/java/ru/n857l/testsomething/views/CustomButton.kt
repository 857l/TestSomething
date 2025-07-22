package ru.n857l.testsomething.views

import android.content.Context
import android.graphics.Color
import android.os.Parcelable
import android.util.AttributeSet
import ru.n857l.testsomething.ButtonUiState

class CustomButton : androidx.appcompat.widget.AppCompatButton, UpdateChoiceButton {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private lateinit var state: ButtonUiState

    override fun getFreezesText(): Boolean = true

    override fun update(state: ButtonUiState) {
        this.state = state
        state.update(this)
    }

    override fun update(color: String, clickable: Boolean, enable: Boolean) {
        setBackgroundColor(Color.parseColor(color))
        isEnabled = clickable
        isEnabled = enable
    }

    override fun update(text: String) {
        this.text = text
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val savedState = ButtonSavedState(it)
            savedState.save(state)
            return savedState
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ButtonSavedState
        super.onRestoreInstanceState(restoredState.superState)
        update(restoredState.restore())
    }

}

interface UpdateChoiceButton : UpdateText {
    fun update(state: ButtonUiState)

    fun update(
        color: String,
        clickable: Boolean,
        enable: Boolean
    )
}