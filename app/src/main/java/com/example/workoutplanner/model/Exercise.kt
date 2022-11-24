package com.example.workoutplanner.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "exercise_tbl")
data class Exercise(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "exercise_name")
    val name: String,

    @ColumnInfo(name = "sets_amount")
    val sets: String,

    @ColumnInfo(name = "reps_amount")
    val reps: String,
)
