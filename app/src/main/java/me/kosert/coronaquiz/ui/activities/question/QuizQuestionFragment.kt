package me.kosert.coronaquiz.ui.activities.question

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.animation.doOnEnd
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.fragment_question.*
import me.kosert.coronaquiz.BR
import me.kosert.coronaquiz.R
import me.kosert.coronaquiz.databinding.ItemQuizCheckboxBinding
import me.kosert.coronaquiz.databinding.ItemQuizRadioBinding
import me.kosert.coronaquiz.quiz.CheckBoxAnswer
import me.kosert.coronaquiz.quiz.Question
import me.kosert.coronaquiz.quiz.RadioAnswer

class QuizQuestionFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(activity!!).get(QuizViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        answersRecycler.layoutManager = LinearLayoutManager(context)
        nextButton.setOnClickListener { viewModel.goNext() }
        prevButton.setOnClickListener { activity?.onBackPressed() }

        viewModel.currentQuestion.observe(this) { question ->
            nextButton.isEnabled = false
            ValueAnimator.ofFloat(1f, 0f).apply {
                addUpdateListener {
                    questionText.alpha = it.animatedValue as Float
                    answersRecycler.alpha = it.animatedValue as Float
                }
                doOnEnd {
                    updateContent(question)
                    ValueAnimator.ofFloat(0f, 1f).apply {
                        addUpdateListener {
                            questionText.alpha = it.animatedValue as Float
                            answersRecycler.alpha = it.animatedValue as Float
                        }
                    }.start()
                }
            }.start()
        }

        viewModel.currentQuestionIndex.observe(this) {
            prevButton.isEnabled = it != 0
        }
    }

    private fun updateContent(question: Question) {
        questionText.setText(question.questionText)
        nextButton.isEnabled = !question.isAnswerRequired || question.answers.any { it.isSelected }

        LastAdapter(question.answers, BR.answer)
            .map<RadioAnswer, ItemQuizRadioBinding>(R.layout.item_quiz_radio) {
                onBind {
                    val radio = it.itemView as AppCompatRadioButton
                    radio.setOnCheckedChangeListener { _, isChecked ->
                        if (!isChecked) return@setOnCheckedChangeListener

                        nextButton.isEnabled = true
                        val index = question.answers.indexOfFirst { it.isSelected }
                        question.answers.getOrNull(index)?.let { it.isSelected = false }
                        answersRecycler.adapter?.notifyItemChanged(index)
                        it.binding.answer?.isSelected = true
                    }
                }
            }
            .map<CheckBoxAnswer, ItemQuizCheckboxBinding>(R.layout.item_quiz_checkbox) {
                onBind {
                    val check = it.itemView as AppCompatCheckBox
                    check.setOnCheckedChangeListener { _, isChecked ->
                        it.binding.answer?.isSelected = isChecked
                    }
                }
            }
            .into(answersRecycler)
    }

    companion object {

        fun newInstance() = QuizQuestionFragment()
    }
}