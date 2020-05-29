package me.kosert.coronaquiz.quiz

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import me.kosert.coronaquiz.R

enum class ResultType(
    val scoreRange: IntRange,
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int,
    @ColorRes val colorRes: Int
) {

    LOW_RISK(0..20, R.string.low_risk, R.drawable.ic_happy_face_24dp, R.color.green),
    MID_RISK(21..40, R.string.mid_risk, R.drawable.ic_mid_face_24dp, R.color.orange),
    HIGH_RISK(41..100, R.string.high_risk, R.drawable.ic_sad_face_24dp, R.color.lipstick)

}