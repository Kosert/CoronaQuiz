package me.kosert.coronaquiz.ui

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.ProgressBar
import me.kosert.coronaquiz.util.dpToPx
import me.kosert.coronaquiz.util.setMargins

class QuizStepsView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val views = mutableListOf<ProgressBar>()

    var progress: Int = 0
        set(value) {

            if (value == field + 1) {
                ValueAnimator.ofInt(0, 100).apply {
                    addUpdateListener { views[value - 1].progress = it.animatedValue as Int }
                }.start()
            }

            if (value == field - 1) {
                ValueAnimator.ofInt(100, 0).apply {
                    addUpdateListener { views[value].progress = it.animatedValue as Int }
                }.start()
            }

            views.take(progress).forEach {
                it.progress = 100
            }
            views.drop(progress).forEach {
                it.progress = 0
            }
            field = value
        }

    var max: Int = 0
        set(value) {
            views.clear()
            removeAllViews()

            progress = 0
            field = value

            repeat(max) { _ ->
                createView().also {
                    addView(it)
                    views.add(it)
                }
            }
        }

    private fun createView(): ProgressBar {
        return ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal).also {
            it.layoutParams = LayoutParams(0, WRAP_CONTENT, 1f)
            it.setMargins(left = 1.dpToPx(context), right = 1.dpToPx(context))
            it.isIndeterminate = false
            it.max = 100
            it.progress = 0
        }
    }


}
