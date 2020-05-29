package me.kosert.coronaquiz.ui.activities.question

import androidx.lifecycle.ViewModel
import me.kosert.coronaquiz.quiz.Questions
import me.kosert.coronaquiz.util.KotlinLiveData

class QuizViewModel : ViewModel() {

    private val questions = Questions.list
    val questionsCount
        get() = questions.size

    val score
        get() = questions.sumBy { question ->
            question.answers.sumBy { if (it.isSelected) it.value else 0 }
        }

    val quizFinished = KotlinLiveData(false)
    val currentQuestion = KotlinLiveData(questions.first())
    val currentQuestionIndex = KotlinLiveData(0)

    fun goBack() {
        val prev = currentQuestionIndex.value - 1
        currentQuestionIndex.value = prev
        currentQuestion.value = questions[prev]
    }

    fun goNext() {
        val next = currentQuestionIndex.value + 1
        currentQuestionIndex.value = next

        if (next == questionsCount) {
            quizFinished.value = true
            return
        }

        currentQuestion.value = questions[next]
    }

}
