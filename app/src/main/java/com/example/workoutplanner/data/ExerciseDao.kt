package com.example.workoutplanner.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.workoutplanner.model.Exercise
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise_tbl")
    fun getExercises(): Flow<List<Exercise>>

    @Query("SELECT * FROM exercise_tbl WHERE id = :id")
    suspend fun getExerciseById(id: String) : Exercise

    @Insert
    suspend fun insertExercise(exercise: Exercise)

    @Delete
    suspend fun deleteExercise(exercise: Exercise)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateExercise(exercise: Exercise)

    @Query("DELETE from exercise_tbl")
    suspend fun deleteAllExercises()

}