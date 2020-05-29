package me.kosert.coronaquiz.util

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import androidx.core.view.updateLayoutParams

@ColorInt
fun Int.toColor(context: Context) = ContextCompat.getColor(context, this)

fun View.visible(value: Boolean) {
    this.visibility = if (value) View.VISIBLE else View.GONE
}

fun View.setMargins(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null) {

    updateLayoutParams<ViewGroup.MarginLayoutParams> {
        setMargins(
            left ?: leftMargin,
            top ?: topMargin,
            right ?: rightMargin,
            bottom ?: rightMargin
        )
    }
}

fun Int.dpToPx(context: Context): Int {
    val dpi = context.resources.displayMetrics.densityDpi
    return this * (dpi / DisplayMetrics.DENSITY_DEFAULT)
}
