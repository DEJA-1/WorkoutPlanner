package com.example.workoutplanner.di

import android.content.Context
import androidx.room.Room
import com.example.workoutplanner.data.ExerciseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideExerciseDao(exerciseDatabase: ExerciseDatabase) = exerciseDatabase.exerciseDao()

    @Singleton
    @Provides
    fun provideExerciseDatabase(@ApplicationContext context: Context) : ExerciseDatabase =
        Room.databaseBuilder(
            context,
            ExerciseDatabase::class.java,
            "exercise_db"
        ).build()
}