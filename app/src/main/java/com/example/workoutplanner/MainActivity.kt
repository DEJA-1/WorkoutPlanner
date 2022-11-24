package com.example.workoutplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.workoutplanner.screen.MainScreen
import com.example.workoutplanner.ui.theme.WorkoutPlannerTheme
import com.example.workoutplanner.viewmodel.ExerciseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutPlannerTheme {
                // A surface container using the 'background' color from the theme
                val exerciseViewModel: ExerciseViewModel by viewModels()
                WorkoutPlanner(exerciseViewModel = exerciseViewModel)

            }
        }
    }
}

@Composable
fun WorkoutPlanner(exerciseViewModel: ExerciseViewModel = viewModel()) {

    val exerciseList = exerciseViewModel.exerciseList.collectAsState().value
    MainScreen(exercises = exerciseList,
        onRemoveExercise = { exerciseViewModel.deleteExercise(it) },
        onAddExercise = { exerciseViewModel.insertExercise(it) })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorkoutPlannerTheme {

    }
}