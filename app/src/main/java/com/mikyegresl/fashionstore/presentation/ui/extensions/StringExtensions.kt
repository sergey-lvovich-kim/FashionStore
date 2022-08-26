package com.mikyegresl.fashionstore.presentation.ui.extensions

import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.mikyegresl.fashionstore.Constants

fun String?.fromHtml(): Spanned =
    HtmlCompat.fromHtml(
        this ?: Constants.EMPTY_STRING,
        HtmlCompat.FROM_HTML_SEPARATOR_LINE_BREAK_LIST
    )