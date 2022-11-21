package com.example.workoutplanner.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ExerciseInputText(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    shape: RoundedCornerShape = RoundedCornerShape(6.dp),
    color: Color = Color(0xFFEEC80A),
    maxLine: Int = 1,
    onImeAction: () -> Unit = {},
    onTextChanged: (String) -> Unit,
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChanged,
        label = { Text(text = label) },
        maxLines = maxLine,
        shape = shape,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = color,
            focusedLabelColor = color
        ),
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            keyboardController?.hide()
        })
    )

}

@Composable
fun ExerciseButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    color: Color,
    enabled: Boolean = true,
) {

    Button(onClick = onClick,
        modifier = modifier,
        shape = CircleShape,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        elevation = ButtonDefaults.elevation(4.dp)) {
        Text(text = text)
    }

}