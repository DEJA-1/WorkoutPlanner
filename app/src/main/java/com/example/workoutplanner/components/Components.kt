package com.example.workoutplanner.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
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