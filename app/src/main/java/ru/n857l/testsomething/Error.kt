package ru.n857l.testsomething

import androidx.annotation.StringRes

interface Error {

    fun message() : String

    abstract class Abstract(
        private val manageResources: ManageResources,
        @StringRes private val messageId: Int
    ) : Error {
        override fun message(): String = manageResources.string(messageId)
    }

    class NoConnection(
        private val manageResources: ManageResources
    ) : Abstract(manageResources, R.string.no_connection_message)

    class ServiceUnavailable(
        private val manageResources: ManageResources
    ) : Abstract(manageResources, R.string.no_connection_message)
}