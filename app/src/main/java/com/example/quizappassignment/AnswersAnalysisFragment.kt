package com.example.quizappassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.quizappassignment.Utils.Companion.questions
import com.example.quizappassignment.databinding.FragmentAnswerAnalysisBinding


class AnswersAnalysisFragment : Fragment() {

    val args: AnswersAnalysisFragmentArgs by navArgs()
    lateinit var answersList : IntArray


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAnswerAnalysisBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_answer_analysis, container, false)
        answersList = args.answersList
        var analysisString = ""
        questions.forEachIndexed{ index, question ->
            var userAnswerIndex = answersList[index]
            analysisString += "${index+1}. ${question.text} \n " +
                    "Your Ans: ${question.answers[userAnswerIndex]} \n" +
                    "Correct Ans: ${question.answers[0]} \n \n"
        }
        binding.analysisText.text = analysisString

        return binding.root
    }

}