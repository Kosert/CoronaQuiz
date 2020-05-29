package me.kosert.coronaquiz.quiz

import androidx.annotation.StringRes

class Question(
    @StringRes val questionText: Int,
    val answers: List<Answer>
) {

    val isAnswerRequired
        get() = answers.any { it is RadioAnswer }
}