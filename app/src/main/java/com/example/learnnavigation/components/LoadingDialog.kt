package com.example.learnnavigation.components

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.example.learnnavigation.R

class LoadingDialog {
    companion object {
        fun build(context: Context) : AlertDialog {
            val inflate = LayoutInflater.from(context)
                .inflate(R.layout.loading_dialog, null)
            val dialog = AlertDialog.Builder(context)
                .setView(inflate).setCancelable(true).create()
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            return dialog
        }
    }
}