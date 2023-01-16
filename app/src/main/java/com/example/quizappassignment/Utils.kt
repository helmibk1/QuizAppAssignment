package com.example.quizappassignment

class Utils {
    companion object{

        data class Question(
            var index: String = "",
            val text: String,
            val answers: List<String>)
         val questions: MutableList<Question> = mutableListOf(
            Question(
                text = "What is Android Jetpack?",
                answers = listOf("Both", "Tools", "Documentation")
            ),
            Question(
                text = "Which one is an Architecture jetpack Component?",
                answers = listOf("Navigation", "Android KTX", "Permissions")
            ),
            Question(
                text = "What is a ViewModel class?",
                answers = listOf("Business logic class", "Data class", "Customized View")
            ),
            Question(
                text = "Which one of these is considered an observer class?",
                answers = listOf("Live Data", "View Model", "SafeArgs")
            ),
            Question(
                text = "Inflate layout in fragments?",
                answers = listOf("onCreateView", "onViewCreated", "onCreateLayout")
            ),
            Question(
                text = "Navigation Graph includes?",
                answers = listOf(
                    "Destinations as Activities or Fragments",
                    "Destinations as ViewModels",
                    "Google maps"
                )
            ),
            Question(
                text = "Room database is a",
                answers = listOf("Architecture component", "UI component", "Behavior component")
            ),
            Question(
                text = "Android Navigation Component?",
                answers = listOf("NavController", "NavCentral", "NavMaster")
            ),
            Question(
                text = "Suspend keyword enforce a function to be called?",
                answers = listOf(
                    "From a coroutine or a suspend function",
                    "Outside a data class",
                    "Inside a safe thread"
                )
            ),
            Question(
                text = "Mark a layout for Data Binding?",
                answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
            ),
            Question(
                text = "To enable ViewBinding in gradle file we use?",
                answers = listOf(
                    "buildFeatures{ viewBinding true }",
                    "buildFeatures{ Binding true }",
                    "buildTypes{ viewBinding true }"
                )
            ),
            Question(
                text = "An open source standalone database?",
                answers = listOf("SQLite", "BackupHelper", "Retrofit")
            ),
            Question(
                text = "In Navigation Component Destinations are connected using?",
                answers = listOf("Actions", "Links", "Data binding")
            ),
            Question(
                text = "Major components in Room?",
                answers = listOf("Both", "Entity", "Dao")
            ),
            Question(
                text = "A DAO object?",
                answers = listOf("Is an interface", "Holds entities", "Both")
            )
        )
    }
}