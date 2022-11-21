package com.example.workoutplanner.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.workoutplanner.data.ExerciseDataSource
import com.example.workoutplanner.model.Exercise

class ExerciseViewModel : ViewModel() {

    private var exerciseList = mutableStateListOf<Exercise>()

    init {
        exerciseList.addAll(ExerciseDataSource().getExercises())
    }

    fun addExercise(exercise: Exercise) {
        exerciseList.add(exercise)
    }

    fun removeExercise(exercise: Exercise) {
        exerciseList.remove(exercise)
    }

    fun getAllExercises(): List<Exercise> {
        return exerciseList
    }

}