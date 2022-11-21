package com.example.workoutplanner.model

import java.util.UUID

data class Exercise(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val sets: String,
    val reps: String,
)
