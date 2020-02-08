package com.kaungmyatmin.wonder.utli

import android.app.Activity
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.kaungmyatmin.wonder.R


fun Activity.displayToast(@StringRes message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.displayToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.displaySuccessDialog(message: String?) {
    val builder = AlertDialog.Builder(this)
    builder.setTitle(R.string.text_success)
        .setMessage(message)
    val dialog = builder.create()
    dialog.show()
}

fun Activity.displayErrorDialog(message : String?) {
    val builder = AlertDialog.Builder(this)
    builder.setTitle(R.string.text_error)
        .setMessage(message)
    val dialog = builder.create()
    dialog.show()
}

fun Activity.displayInfoDialog(message: String?) {
    val builder = AlertDialog.Builder(this)
    builder.setTitle(R.string.text_info)
        .setMessage(message)
    val dialog = builder.create()
    dialog.show()
}

fun Activity.areYouSureDialog(message: String, callback: AreYouSureCallback) {
    val builder = AlertDialog.Builder(this)
    builder.setTitle(R.string.text_error)
        .setMessage(message)
        .setPositiveButton(R.string.text_ok){
            dialogInterface, which -> callback.proceed()
        }
        .setNegativeButton(R.string.text_cancel){
            dialogInterface, which -> callback.cancel()
        }
    val dialog = builder.create()
    dialog.show()
}


interface AreYouSureCallback {

    fun proceed()

    fun cancel()
}









