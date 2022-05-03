package com.example.constrastoque.common

import android.text.Html
import android.text.Spanned
import android.widget.TextView

fun TextView.setHTML(html: String) {
    text = html.asHTML()
}

fun String.asHTML(): Spanned =
    Html.fromHtml(
        this,
        Html.FROM_HTML_MODE_LEGACY
    )