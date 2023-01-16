package com.example.quizappassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.quizappassignment.Utils.Companion.questions
import com.example.quizappassignment.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    lateinit var currentQuestion: Utils.Companion.Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = 15
    private var correctQuestions = 0

    var answersList = IntArray(numQuestions)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false)

        randomizeQuestions()

        binding.game = this

        binding.nextButton.setOnClickListener { view: View ->

            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                }

                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    correctQuestions++
                }
                answersList[questionIndex] = answerIndex
                questionIndex++
                // Advance to the next question
                if (questionIndex < numQuestions) {
                    binding.questionRadioGroup.clearCheck()
                    currentQuestion.index = (questionIndex+1).toString() + ")"
                    currentQuestion = questions[questionIndex]
                    setQuestion()
                    binding.invalidateAll()
                } else {
                    //Navigate to the gameWonFragment.
                    view.findNavController().navigate(QuizFragmentDirections.actionGameFragmentToGameWonFragment(correctQuestions,answersList))
                }

            }
        }
        binding.homeButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_gameFragment_to_titleFragment)
        }
        return binding.root
    }

    private fun randomizeQuestions() {
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        currentQuestion.index = (questionIndex+1).toString() + ") "
        answers = currentQuestion.answers.toMutableList()
    }
}