package com.example.compose_demo.module.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose_demo.R
import com.example.compose_demo.ui.composables.CustomStyleTextField

@Composable
fun RegisterPage(navController: NavHostController) {
    Scaffold {
        val context = LocalContext.current
        var isTermsAccepted by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .fillMaxHeight(.25f)
                    .fillMaxWidth(.7f),
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = "logo"
            )

            Card(
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .padding(top = 20.dp)
                    .verticalScroll(rememberScrollState()),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                val fullNameState = remember { mutableStateOf(TextFieldValue("")) }
                val mobileState = remember { mutableStateOf(TextFieldValue("")) }
                val emailTextState = remember { mutableStateOf(TextFieldValue("")) }
                val passTextState = remember { mutableStateOf(TextFieldValue("")) }
                val conPassTextState = remember { mutableStateOf(TextFieldValue("")) }
                var mobErrorMessage by remember { mutableStateOf("") }
                var passwordErrorMessage by remember { mutableStateOf("") }
                var nameErrorMessage by remember { mutableStateOf("") }
                var emailErrorMessage by remember { mutableStateOf("") }
                var conPasswordErrorMessage by remember { mutableStateOf("") }

                val mobileRegex = "^[6-9]\\d{9}$".toRegex()
                val passwordRegex =
                    """^(?=.*[A-Z])(?=.*[\W_])(?=.*\d)[A-Za-z\d\W_]{8,}$""".toRegex()
                val emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$".toRegex()

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 10.dp),
                        text = "Sing up your account.",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        text = "Full Name*",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(bottom = 5.dp, top = 10.dp)
                    )

                    CustomStyleTextField(
                        placeHolder = "Full Name",
                        leadingIconId = Icons.Default.Person,
                        keyboardType = KeyboardType.Text,
                        keyboardCapitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Next,
                        visualTransformation = VisualTransformation.None,
                        textState = fullNameState.value,
                        onValueChanged = { newValue ->

                            fullNameState.value = newValue
                            nameErrorMessage = ""

                        }
                    )
                    if (nameErrorMessage.isNotEmpty()) {
                        Text(
                            text = nameErrorMessage,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                    Text(
                        text = "Mobile Number*",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(bottom = 5.dp, top = 20.dp)
                    )

                    CustomStyleTextField(
                        placeHolder = "Mobile Number",
                        leadingIconId = Icons.Default.Phone,
                        keyboardType = KeyboardType.Phone,
                        keyboardCapitalization = KeyboardCapitalization.None,
                        imeAction = ImeAction.Next,
                        visualTransformation = VisualTransformation.None,
                        textState = mobileState.value,
                        onValueChanged = { newValue ->
                            val filteredText = newValue.text.filter { it.isDigit() }
                            if (filteredText.length <= 10) {
                                mobileState.value = newValue
                                mobErrorMessage = ""
                            }
                        }
                    )
                    if (mobErrorMessage.isNotEmpty()) {
                        Text(
                            text = mobErrorMessage,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }


                    Text(
                        text = "Email Address*",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(bottom = 5.dp, top = 20.dp)
                    )

                    CustomStyleTextField(
                        placeHolder = "Email Address",
                        leadingIconId = Icons.Default.Email,
                        keyboardType = KeyboardType.Email,
                        keyboardCapitalization = KeyboardCapitalization.None,
                        imeAction = ImeAction.Next,
                        visualTransformation = VisualTransformation.None,
                        textState = emailTextState.value,
                        onValueChanged = { newValue ->
                            emailTextState.value = newValue
                            emailErrorMessage = ""
                        }
                    )
                    if (emailErrorMessage.isNotEmpty()) {
                        Text(
                            text = emailErrorMessage,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                    Text(
                        text = "Password*",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(bottom = 5.dp, top = 20.dp)
                    )
                    CustomStyleTextField(
                        placeHolder = "Password",
                        leadingIconId = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        keyboardCapitalization = KeyboardCapitalization.None,
                        imeAction = ImeAction.Done,
                        visualTransformation = PasswordVisualTransformation(),
                        textState = passTextState.value,
                        onValueChanged = { newValue ->
                            passTextState.value = newValue
                            passwordErrorMessage = ""
                        }
                    )
                    if (passwordErrorMessage.isNotEmpty()) {
                        Text(
                            text = passwordErrorMessage,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }


                    Text(
                        text = "Confirm Password*",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(bottom = 5.dp, top = 20.dp)
                    )
                    CustomStyleTextField(
                        placeHolder = "Confirm Password",
                        leadingIconId = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        keyboardCapitalization = KeyboardCapitalization.None,
                        imeAction = ImeAction.Done,
                        visualTransformation = PasswordVisualTransformation(),
                        textState = conPassTextState.value,
                        onValueChanged = { newValue ->
                            conPassTextState.value = newValue
                            conPasswordErrorMessage = ""
                        }
                    )
                    if (conPasswordErrorMessage.isNotEmpty()) {
                        Text(
                            text = conPasswordErrorMessage,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(30.dp))


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(25.dp)
                            .align(alignment = Alignment.Start)
                    ) {
                        Checkbox(
                            checked = isTermsAccepted,
                            onCheckedChange = { isTermsAccepted = it }
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("I accept the Terms and Conditions")
                    }


                    ElevatedButton(
                        onClick = {
                            if (fullNameState.value.text.isEmpty()) {
                                nameErrorMessage =
                                    "Please enter your full name."
                            }else if (!mobileRegex.matches(mobileState.value.text)) {
                            mobErrorMessage =
                                "Please enter a valid 10 digit mobile number starting from 6 to 9."
                        } else if (!emailRegex.matches(emailTextState.value.text)) {
                                emailErrorMessage =
                                    "Please enter valid email address."

                            } else if (!passwordRegex.matches(passTextState.value.text)) {
                                passwordErrorMessage =
                                    "Password must be at least 8 characters long, with at least one uppercase letter, one number, and one special character."
                            } else if (passTextState.value.text != conPassTextState.value.text) {
                                conPasswordErrorMessage =
                                    "Password and confirm password did not matched."
                            } else if (!isTermsAccepted) {
                                Toast.makeText(
                                    context,
                                    "Please accept terms and conditions",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                //navigate to your screen
                            }
                        },
                        modifier = Modifier
                            .padding(top = 30.dp, bottom = 34.dp)
                            .align(Alignment.CenterHorizontally)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.elevatedButtonColors(
                            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            contentColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 6.dp, bottom = 6.dp),
                            text = "Login",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                navController.navigate("login")
                            },
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        val signInText = "Already have an account? Sign In"
                        val signInWord = "Sign In"
                        val signInAnnotatedString = buildAnnotatedString {
                            append(signInText)
                            addStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.secondary,
                                ),
                                start = 0,
                                end = signInText.length
                            )
                            addStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                ),
                                start = signInText.indexOf(signInWord),
                                end = signInText.length
                            )
                        }

                        Text(
                            modifier = Modifier
                                .padding(bottom = 10.dp),
                            text = signInAnnotatedString,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center
                        )
                    }

                }
            }


        }
    }
}



