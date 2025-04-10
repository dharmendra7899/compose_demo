package com.example.compose_demo.module.auth

import android.widget.Toast
import com.example.compose_demo.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.compose_demo.ui.composables.CustomStyleTextField

@Composable
fun LoginPage(navController: NavHostController) {


    Scaffold { paddingValues ->
        val context = LocalContext.current
        var isTermsAccepted by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .padding(paddingValues)
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
                val mobileState = remember { mutableStateOf(TextFieldValue("")) }
                val passTextState = remember { mutableStateOf(TextFieldValue("")) }

                var mobErrorMessage by remember { mutableStateOf("") }
                var passwordErrorMessage by remember { mutableStateOf("") }

                val mobileRegex = "^[6-9]\\d{9}$".toRegex()
                val passwordRegex =
                    """^(?=.*[A-Z])(?=.*[\W_])(?=.*\d)[A-Za-z\d\W_]{8,}$""".toRegex()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 20.dp),
                        text = "Log in to your account.",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,

                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )


                    Text(
                        text = "Mobile Number*",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(bottom = 5.dp, top = 10.dp)
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate("forgot_password")
                            }
                            .padding(top = 10.dp),
                        text = "Forgot Password?",
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.labelLarge
                    )

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
                            if (!mobileRegex.matches(mobileState.value.text)) {
                                mobErrorMessage =
                                    "Please enter a valid 10 digit mobile number starting from 6 to 9."
                            } else if (!passwordRegex.matches(passTextState.value.text)) {
                                passwordErrorMessage =
                                    "Password must be at least 8 characters long, with at least one uppercase letter, one number, and one special character."
                            } else if (!isTermsAccepted) {
                                Toast.makeText(
                                    context,
                                    "Please accept terms and conditions",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                navController.navigate("dashboard")
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

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                navController.navigate("signUp")
                            },
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        val signInText = "Don't have an account? Sign Up"
                        val signInWord = "Sign Up"
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
