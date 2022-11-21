package com.example.workoutplanner.screen

import android.content.Context
import android.icu.text.CaseMap
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workoutplanner.components.ExerciseButton
import com.example.workoutplanner.components.ExerciseInputText
import com.example.workoutplanner.model.Exercise

@Composable
fun MainScreen(
    exercises: List<Exercise>,
    onRemoveExercise: (Exercise) -> Unit,
    onAddExercise: (Exercise) -> Unit = {},
) {

    var name by remember {
        mutableStateOf("")
    }

    var sets by remember {
        mutableStateOf("")
    }

    var reps by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column() {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(20.dp),
            backgroundColor = Color(0xFFE6AF2E)) {

            Column(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Plan your workout",
                    style = MaterialTheme.typography.caption,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 50.sp,
                    textAlign = TextAlign.Center)
            }

        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            ExerciseInputText(
                text = name,
                label = "Name",
                onTextChanged = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        })
                        name = it
                }
            )

            Row(modifier = Modifier.padding(8.dp)) {
                ExerciseInputText(
                    modifier = Modifier.fillMaxWidth(0.48f),
                    text = sets,
                    label = "Sets",
                    onTextChanged = {
                        if (it.all { char ->
                                char.isDigit()
                            })
                            sets = it
                    }
                )

                Spacer(modifier = Modifier.width(10.dp))

                ExerciseInputText(
                    text = reps,
                    label = "Reps",
                    onTextChanged = {
                        if (it.all { char ->
                                char.isDigit()
                            })
                            reps = it
                    }
                )
            }

            ExerciseButton(modifier = Modifier.fillMaxWidth()
                .padding(4.dp),
                text = "Save",
                onClick = {
                    if (name.isNotEmpty() && sets.isNotEmpty() && reps.isNotEmpty()) {
                        onAddExercise(Exercise(name = name, sets = sets, reps = reps))
                        name = ""
                        sets = ""
                        reps = ""
                        Toast.makeText(context, "Exercise Added", Toast.LENGTH_SHORT).show()
                    }
                },
                color = Color(0xFF00AF54))

            LazyColumn {

                items(exercises) { exercise ->
                    ExerciseRow(exercise = exercise,
                        onExerciseClicked = {
                            onRemoveExercise(exercise)
                        },
                        context = context)
                }

            }

        }
    }

}

@Composable
fun ExerciseRow(
    exercise: Exercise,
    onExerciseClicked: (Exercise) -> Unit,
    context: Context,
) {
    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        color = Color(0xFFE6AF2E),
        elevation = 6.dp) {

        Column(modifier = Modifier
            .padding(horizontal = 14.dp, vertical = 6.dp)
            .clickable {
                onExerciseClicked(exercise)
                Toast
                    .makeText(context, "Note Removed", Toast.LENGTH_SHORT)
                    .show()
            },
            horizontalAlignment = Alignment.Start) {
            Text(text = exercise.name,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic)

            Row(modifier = Modifier.padding(4.dp)) {
                Text(text = "Sets: ${exercise.sets}",
                    style = MaterialTheme.typography.subtitle2)

                Spacer(modifier = Modifier.width(10.dp))

                Text(text = "Reps: ${exercise.reps}",
                    style = MaterialTheme.typography.subtitle2)
            }


        }


    }
}