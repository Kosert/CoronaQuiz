package me.kosert.coronaquiz.ui.activities.question

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_quiz.*
import me.kosert.coronaquiz.R

class QuizActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        quizSteps.max = viewModel.questionsCount
        closeButton.setOnClickListener { finish() }

        viewModel.currentQuestionIndex.observe(this) {
            quizSteps.progress = it
        }

        viewModel.quizFinished.observe(this) { finished ->
            val current = supportFragmentManager.findFragmentByTag(TAG)
            if (!finished && current is QuizQuestionFragment)
                return@observe
            if (finished && current is QuizResultFragment)
                return@observe

            val fragment = if (finished)
                QuizResultFragment.newInstance()
            else
                QuizQuestionFragment.newInstance()

            supportFragmentManager.beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragmentContainer, fragment, TAG)
                .commit()
        }
    }

    override fun onBackPressed() {
        when (viewModel.currentQuestionIndex.value) {
            0, viewModel.questionsCount -> super.onBackPressed()
            else -> viewModel.goBack()
        }
    }

    companion object {
        const val TAG = "QuizActivityFragment.TAG"
    }
}