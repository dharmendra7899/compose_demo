package com.example.compose_demo.ui.composables

import android.R.attr.maxLength
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_demo.R


/**
 * @Created by Dharmendra Kumar on 10-04-2025.
 * Custom text field with leading and trailing icons.
 */
@Composable
fun CustomStyleTextField(
    placeHolder: String,
    leadingIconId: ImageVector,
    keyboardType: KeyboardType,
    keyboardCapitalization: KeyboardCapitalization,
    imeAction: ImeAction,
    visualTransformation: VisualTransformation,
    textState: TextFieldValue,
    onValueChanged: (TextFieldValue) -> Unit
) {
    var textTransformation by remember { mutableStateOf(visualTransformation) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(8.dp)),
        value = textState,
        singleLine = true,
        onValueChange = onValueChanged,
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = keyboardCapitalization,
            autoCorrectEnabled = true,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        placeholder = { Text(text = placeHolder) },
        leadingIcon = {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(start = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(18.dp),
                    imageVector = leadingIconId,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                    contentDescription = "leading_icon"
                )
            }
        },
        trailingIcon = if (visualTransformation == PasswordVisualTransformation()) {
            {
                IconButton(onClick = {
                    textTransformation = if (textTransformation == PasswordVisualTransformation())
                        VisualTransformation.None
                    else PasswordVisualTransformation()
                }) {
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(
                            if (textTransformation == PasswordVisualTransformation())
                                R.drawable.baseline_visibility_24
                            else
                                R.drawable.baseline_visibility_off_24
                        ),
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                        contentDescription = "visibility_toggle"
                    )
                }
            }
        } else null,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = Color.Transparent,
            focusedTrailingIconColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurface,
        ),
        shape = RoundedCornerShape(8.dp),
        textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface, fontSize = 16.sp),
        visualTransformation = textTransformation
    )
}


