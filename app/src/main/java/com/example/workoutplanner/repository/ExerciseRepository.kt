package com.example.workoutplanner.repository

import com.example.workoutplanner.data.ExerciseDao
import com.example.workoutplanner.model.Exercise
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ExerciseRepository @Inject constructor(
    private val exerciseDao: ExerciseDao,
) {

    suspend fun insertExercise(exercise: Exercise) = exerciseDao.insertExercise(exercise)
    suspend fun deleteExercise(exercise: Exercise) = exerciseDao.deleteExercise(exercise)
    suspend fun updateExercise(exercise: Exercise) = exerciseDao.updateExercise(exercise)
    suspend fun deleteAllExercises() = exerciseDao.deleteAllExercises()
    fun getAllExercises(): Flow<List<Exercise>> = exerciseDao.getExercises().flowOn(Dispatchers.IO).conflate()

}