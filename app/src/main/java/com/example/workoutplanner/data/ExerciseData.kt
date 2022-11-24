package com.example.workoutplanner.data

import com.example.workoutplanner.model.Exercise

class ExerciseDataSource() {

    fun getExercises(): List<Exercise> {

        return listOf(

            Exercise(
                name = "Do anything",
                sets = "15",
                reps = "14"
            ),

            Exercise(
                name = "Do anything",
                sets = "15",
                reps = "14"
            ),

            Exercise(
                name = "Do anything",
                sets = "15",
                reps = "14"
            ),

            Exercise(
                name = "Do anything",
                sets = "15",
                reps = "14"
            ),

        )

    }

}