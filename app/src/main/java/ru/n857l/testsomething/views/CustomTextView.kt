package ru.n857l.testsomething.views

import android.content.Context
import android.util.AttributeSet

class CustomTextView : androidx.appcompat.widget.AppCompatTextView, UpdateText {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun update(text: String) {
        setText(text)
    }

    override fun getFreezesText(): Boolean = true

}

interface UpdateText {
    fun update(text: String)
}