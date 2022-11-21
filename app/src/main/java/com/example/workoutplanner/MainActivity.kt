package com.example.workoutplanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.workoutplanner.screen.MainScreen
import com.example.workoutplanner.ui.theme.WorkoutPlannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkoutPlannerTheme {
                // A surface container using the 'background' color from the theme
                WorkoutPlanner()

            }
        }
    }
}

@Composable
fun WorkoutPlanner() {

    MainScreen()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WorkoutPlannerTheme {

    }
}