package me.kosert.coronaquiz.quiz

import me.kosert.coronaquiz.R

object Questions {

    val list
        get() = listOf(
            Question(
                R.string.fever_question,
                listOf(
                    RadioAnswer(R.string.fever_gt_38, 20),
                    RadioAnswer(R.string.fever_lt_38, 10),
                    RadioAnswer(R.string.no, 10)
                )
            ),
            Question(
                R.string.cough_question,
                listOf(
                    RadioAnswer(R.string.yes, 10),
                    RadioAnswer(R.string.blood_cough, 20),
                    RadioAnswer(R.string.no, 0)
                )
            ),
            Question(
                R.string.shortness_of_breath_question,
                listOf(
                    RadioAnswer(R.string.yes, 15),
                    RadioAnswer(R.string.no, 0)
                )
            ),
            Question(
                R.string.faster_breath_question,
                listOf(
                    RadioAnswer(R.string.yes, 15),
                    RadioAnswer(R.string.no, 0)
                )
            ),
            Question(
                R.string.other_symptoms_question,
                listOf(
                    CheckBoxAnswer(R.string.weakness, 4),
                    CheckBoxAnswer(R.string.muscle_ache, 4),
                    CheckBoxAnswer(R.string.chills, 0),
                    CheckBoxAnswer(R.string.headache, 4),
                    CheckBoxAnswer(R.string.diarrhea, 2),
                    CheckBoxAnswer(R.string.runny_nose, 2),
                    CheckBoxAnswer(R.string.nausea, 0),
                    CheckBoxAnswer(R.string.sore_throat, 4)
                )
            ),
            Question(
                R.string.symptoms_acceleration_question,
                listOf(
                    RadioAnswer(R.string.yes, 10),
                    RadioAnswer(R.string.no, 0)
                )
            )
        )
}