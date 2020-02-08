package com.kaungmyatmin.wonder.bases

import com.kaungmyatmin.wonder.utli.DataState

interface DataStateChangeListener{

    fun onDataStateChange(dataState: DataState<*>?)

    fun expandAppBar()

    fun hideSoftKeyboard()

    fun isStoragePermissionGranted(): Boolean
}