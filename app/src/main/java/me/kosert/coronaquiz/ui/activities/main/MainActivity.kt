package me.kosert.coronaquiz.ui.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.kosert.coronaquiz.R
import me.kosert.coronaquiz.ui.activities.question.QuizActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        closeButton.setOnClickListener { onBackPressed() }

        startButton.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }
}
