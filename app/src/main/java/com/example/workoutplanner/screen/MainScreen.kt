package com.example.workoutplanner.screen

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.workoutplanner.components.ExerciseInputText


@Preview
@Composable
fun MainScreen() {

    var title by remember {
        mutableStateOf("")
    }

    var sets by remember {
        mutableStateOf("")
    }

    var reps by remember {
        mutableStateOf("")
    }

    Column() {
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
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
                text = title,
                label = "Title",
                onTextChanged = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace() })
                        title = it
                }
            )

            Row(modifier = Modifier.padding(8.dp)) {
                ExerciseInputText(
                    modifier = Modifier.fillMaxWidth(0.48f),
                    text = sets,
                    label = "Sets",
                    onTextChanged = {
                        if (it.all { char ->
                                char.isDigit() })
                            sets = it
                    }
                )
                
                Spacer(modifier = Modifier.width(10.dp))

                ExerciseInputText(
                    text = reps,
                    label = "Reps",
                    onTextChanged = {
                        if (it.all { char ->
                                char.isDigit()})
                            reps = it
                    }
                )
            }


        }
    }


}