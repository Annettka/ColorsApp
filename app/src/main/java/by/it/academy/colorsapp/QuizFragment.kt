package by.it.academy.colorsapp

import android.graphics.Color
import android.graphics.Color.parseColor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class QuizFragment : Fragment() {
    private var score: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val quizFragment = view.findViewById<View>(R.id.quizFragment)
        val hexCode = view.findViewById<TextView>(R.id.hex_code)
        val scoreNum = view.findViewById<TextView>(R.id.score_num)
        val btnYes = view.findViewById<Button>(R.id.btn_yes)
        val btnNo = view.findViewById<Button>(R.id.btn_no)
        var color = randomColor()
        if (color == "#000000") hexCode.setTextColor(Color.WHITE)
        else hexCode.setTextColor(Color.BLACK)
        quizFragment.setBackgroundColor(parseColor(color))
        hexCode.text = randomHexCode()

        btnYes.setOnClickListener {
            if (color == hexCode.text) {
                score++
            } else score--
            scoreNum.text = score.toString()
            color = randomColor()
            if (color == "#000000") hexCode.setTextColor(Color.WHITE)
            else hexCode.setTextColor(Color.BLACK)
            quizFragment.setBackgroundColor(parseColor(color))
            hexCode.text = randomHexCode()
        }

        btnNo.setOnClickListener {
            if (color != hexCode.text) {
                score++
            } else score--
            scoreNum.text = score.toString()
            color = randomColor()
            if (color == "#000000") hexCode.setTextColor(Color.WHITE)
            else hexCode.setTextColor(Color.BLACK)
            quizFragment.setBackgroundColor(parseColor(color))
            hexCode.text = randomHexCode()
        }
    }

    private fun randomColor(): String {
        return MainActivity.colorsList[Random.nextInt(
            0,
            MainActivity.colorsList.size + 1
        )].colorHEXCode
    }

    private fun randomHexCode(): String {
        return MainActivity.colorsList[Random.nextInt(
            0,
            MainActivity.colorsList.size + 1
        )].colorHEXCode
    }
}