package me.kosert.coronaquiz.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import android.widget.RelativeLayout
import androidx.core.view.updateLayoutParams


@BindingAdapter("android:src")
fun setImageViewResource(view: ImageView, resId: Int) {
    view.setImageResource(resId)
}

@BindingAdapter("android:layout_centerVertical")
fun setCenterVertical(view: View, isCenterVertical: Boolean) {

    view.updateLayoutParams<RelativeLayout.LayoutParams> {
        val value = if (isCenterVertical) RelativeLayout.TRUE else 0
        addRule(RelativeLayout.CENTER_VERTICAL, value)
    }
}