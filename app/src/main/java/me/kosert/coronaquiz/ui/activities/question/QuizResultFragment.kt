package me.kosert.coronaquiz.ui.activities.question

import android.content.Intent
import android.content.res.ColorStateList
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_results.*
import me.kosert.coronaquiz.R
import me.kosert.coronaquiz.quiz.ResultType
import me.kosert.coronaquiz.util.toColor

class QuizResultFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(activity!!).get(QuizViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context = view.context

        val result = ResultType.values().first { viewModel.score in it.scoreRange }
        quizResult.setText(result.titleRes)
        quizResult.setTextColor(result.colorRes.toColor(context))
        quizImage.setImageResource(result.iconRes)
        quizImage.imageTintList = ColorStateList.valueOf(result.colorRes.toColor(context))

        resultTitle.setText(
            if (result == ResultType.HIGH_RISK)
                R.string.high_risk_title
            else
                R.string.not_covid_title
        )

        resultDescription.setText(
            if (result == ResultType.HIGH_RISK)
                R.string.high_risk_description
            else
                R.string.not_covid_description
        )

        stationsButton.setOnClickListener {
            showWebsite("https://www.gov.pl/web/koronawirus/stacje-sanitarno-epidemiologiczne")
        }

        infoButton.setOnClickListener {
            showWebsite("https://www.gov.pl/web/koronawirus")
        }
    }

    private fun showWebsite(url: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    companion object {

        fun newInstance() = QuizResultFragment()
    }

}