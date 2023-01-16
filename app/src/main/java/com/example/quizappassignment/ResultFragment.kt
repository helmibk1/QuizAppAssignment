package com.example.quizappassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quizappassignment.databinding.FragmentResultBinding

class ResultFragment : Fragment() {




    val args: ResultFragmentArgs by navArgs()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentResultBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_result, container, false)
        binding.tryAgainButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
        }
        binding.analysisButton.setOnClickListener { view: View ->
            view.findNavController().navigate(ResultFragmentDirections.actionGameWonFragmentToResultFragment(args.answers))
        }

        val correctAnswers = args.correctAnswers
        var totalQuestionsText = "Total Questions : 15"
        var correctAnswersText = "Correct Answers : $correctAnswers"
        var wrongAnswersText = "Wrong Answers : ${15 - correctAnswers}"
        var scoreText = "Your Score is : ${15 - correctAnswers}/15"



        binding.results = Result(totalQuestionsText,correctAnswersText,wrongAnswersText,scoreText)



        return binding.root
    }
    data class Result(val totalQuestionsText: String,val correctAnswersText: String,val wrongAnswersText: String,val scoreText: String)
}