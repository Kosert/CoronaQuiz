package me.kosert.coronaquiz.quiz

import androidx.annotation.StringRes

abstract class Answer(
    @StringRes val answerText: Int,
    val value: Int
) {
    var isSelected: Boolean = false
}

class RadioAnswer(answerText: Int, value: Int) : Answer(answerText, value)
class CheckBoxAnswer(answerText: Int, value: Int) : Answer(answerText, value)