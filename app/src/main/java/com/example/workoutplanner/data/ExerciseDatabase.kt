package com.example.workoutplanner.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workoutplanner.model.Exercise

@Database(entities = [Exercise::class], version = 1, exportSchema = false)
abstract class ExerciseDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
}