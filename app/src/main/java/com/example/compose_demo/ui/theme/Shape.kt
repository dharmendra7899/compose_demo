package com.example.compose_demo.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

fun Modifier.cornerRadius(radius: Int) =
    graphicsLayer(shape = RoundedCornerShape(radius.dp), clip = true)


//                    Spacer(modifier = Modifier.height(50.dp))
//                    Card(
//                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
//                        modifier = Modifier
////                            .fillMaxSize()
//                            .padding(top = 20.dp)
//                            .constrainAs(image) {
//                                top.linkTo(image.bottom, margin = 16.dp)
////                                top.linkTo(image.bottom)
////                                bottom.linkTo(parent.bottom)
////                                start.linkTo(parent.start)
////                                end.linkTo(parent.end)
//                            },
//                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
//                    ) {
//                        val emailTextState = remember { mutableStateOf(TextFieldValue("")) }
//                        val passTextState = remember { mutableStateOf(TextFieldValue("")) }
//                        Column(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .padding(20.dp)
//                        ) {
//                            Text(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(top = 10.dp, bottom = 20.dp),
//                                text = "Log in to your account.",
//                                textAlign = TextAlign.Center,
//                                fontSize = 20.sp,
//                                color = MaterialTheme.colorScheme.onSecondaryContainer
//                            )
//                            Text(
//                                text = "Mobile Number*",
//                                style = MaterialTheme.typography.labelLarge,
//                                modifier = Modifier.padding(bottom = 5.dp, top = 10.dp)
//                            )
//
//                            CustomStyleTextField(
//                                placeHolder = "Mobile Number",
//                                leadingIconId = Icons.Default.Phone,
//                                keyboardType = KeyboardType.Phone,
//                                visualTransformation = VisualTransformation.None,
//                                emailTextState.value
//                            ) {
//                                emailTextState.value = it
//                            }
//
//                            Text(
//                                text = "Password",
//                                style = MaterialTheme.typography.labelLarge,
//                                modifier = Modifier.padding(bottom = 5.dp, top = 20.dp)
//                            )
//                            CustomStyleTextField(
//                                placeHolder = "Password",
//                                leadingIconId = Icons.Default.Lock,
//                                keyboardType = KeyboardType.Password,
//                                visualTransformation = PasswordVisualTransformation(),
//                                textState = passTextState.value
//                            ) {
//                                passTextState.value = it
//                            }
//
//                            Text(
//                                modifier = Modifier
//                                    .fillMaxWidth()
//                                    .padding(top = 10.dp),
//                                text = "Forgot Password?",
//                                textAlign = TextAlign.End,
//                                style = MaterialTheme.typography.labelLarge
//                            )
//
//                            ElevatedButton(
//                                onClick = {
//                                    if (emailTextState.value.text.isEmpty()) {
//                                        Toast.makeText(
//                                            context,
//                                            "Please enter your mobile",
//                                            Toast.LENGTH_SHORT
//                                        ).show()
//                                    } else if (passTextState.value.text.isEmpty()) {
//                                        Toast.makeText(
//                                            context,
//                                            "Please enter your password",
//                                            Toast.LENGTH_SHORT
//                                        ).show()
//                                    } else {
//                                        //navigate to your screen
//                                    }
//                                },
//                                modifier = Modifier
//                                    .padding(top = 30.dp, bottom = 34.dp)
//                                    .align(Alignment.CenterHorizontally)
//                                    .fillMaxWidth(),
//                                shape = RoundedCornerShape(4.dp),
//                                colors = ButtonDefaults.elevatedButtonColors(
//                                    containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
//                                    contentColor = MaterialTheme.colorScheme.secondaryContainer
//                                )
//                            ) {
//                                Text(
//                                    modifier = Modifier.padding(top = 6.dp, bottom = 6.dp),
//                                    text = "Login",
//                                    textAlign = TextAlign.Center,
//                                    style = MaterialTheme.typography.bodyLarge
//                                )
//                            }
//
//                            // Box for SignUp at the bottom
//                            Box(
//                                modifier = Modifier.fillMaxSize(),
//                                contentAlignment = Alignment.BottomCenter
//                            ) {
//                                val signInText = "Don't have an account? Sign Up"
//                                val signInWord = "Sign Up"
//                                val signInAnnotatedString = buildAnnotatedString {
//                                    append(signInText)
//                                    addStyle(
//                                        style = SpanStyle(
//                                            color = MaterialTheme.colorScheme.secondary,
//                                        ),
//                                        start = 0,
//                                        end = signInText.length
//                                    )
//                                    addStyle(
//                                        style = SpanStyle(
//                                            color = MaterialTheme.colorScheme.onSecondaryContainer,
//                                        ),
//                                        start = signInText.indexOf(signInWord),
//                                        end = signInText.length
//                                    )
//                                }
//
//                                Text(
//                                    modifier = Modifier
//                                        .padding(bottom = 20.dp), // Ensure it's 20dp from the bottom
//                                    text = signInAnnotatedString,
//                                    style = MaterialTheme.typography.bodyMedium,
//                                    textAlign = TextAlign.Center
//                                )
//                            }
//                        }
//                    }