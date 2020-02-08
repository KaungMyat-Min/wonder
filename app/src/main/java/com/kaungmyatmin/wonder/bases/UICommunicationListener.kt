package com.kaungmyatmin.wonder.bases

import com.kaungmyatmin.wonder.utli.UIMessage

interface UICommunicationListener {

    fun onUIMessageReceived(uiMessage: UIMessage)
}