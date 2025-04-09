package com.example.compose_demo.module.auth

import android.widget.Toast
import com.example.compose_demo.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compose_demo.ui.composables.CustomStyleTextField

@Composable
fun LoginPage() {

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
                    .fillMaxHeight(.3f)

                    .fillMaxWidth(.6f),
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = "logo"
            )

            Card(
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
                modifier = Modifier.fillMaxHeight(1f)
                    .padding(top = 20.dp).verticalScroll(rememberScrollState()),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                val mobileState = remember { mutableStateOf(TextFieldValue("")) }
                val passTextState = remember { mutableStateOf(TextFieldValue("")) }
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
                        visualTransformation = VisualTransformation.None,
                        mobileState.value
                    ) {
                        mobileState.value = it
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
                        visualTransformation = PasswordVisualTransformation(),
                        textState = passTextState.value
                    ) {
                        passTextState.value = it
                    }

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        text = "Forgot Password?",
                        textAlign = TextAlign.End,
                        style = MaterialTheme.typography.labelLarge
                    )
                    ElevatedButton(
                        onClick = {
                            if (mobileState.value.text.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Please enter your mobile",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else if (passTextState.value.text.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Please enter your password",
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
                        modifier = Modifier.fillMaxSize(),
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
                                .padding(bottom = 20.dp), // Ensure it's 20dp from the bottom
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


//                    Row(modifier= Modifier.fillMaxWidth()) {
//                        Checkbox(
//                            checked = isTermsAccepted,
//                            onCheckedChange = { isTermsAccepted = it }
//                        )
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Text("I accept the Terms and Conditions")
//                    }
