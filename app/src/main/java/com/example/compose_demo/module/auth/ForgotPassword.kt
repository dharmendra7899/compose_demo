package com.example.compose_demo.module.auth

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.compose_demo.R
import com.example.compose_demo.ui.composables.CustomStyleTextField

@Composable
fun ForgotPassword(navController: NavHostController) {
    Scaffold { paddingValues ->
        val context = LocalContext.current


        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            ConstraintLayout(
                modifier = Modifier
                    .fillMaxHeight(0.4f)
                    .fillMaxWidth(1f)
            ) {
                val (image, backButton) = createRefs()

                Image(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    painter = painterResource(id = R.drawable.login_bg),
                    contentDescription = "logo"
                )

                Card(
                    shape = CircleShape,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(12.dp)
                        .constrainAs(backButton) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        },
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.elevatedCardElevation(2.dp)
                ) {
                    IconButton(onClick = { navController.navigate("login") }) {
                        Image(
                            modifier = Modifier
                                .size(25.dp),
                            painter = painterResource(id = R.drawable.ic_bb),
                            contentDescription = "logo"
                        )

                    }
                }
            }




            Card(
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
                modifier = Modifier
                    .fillMaxHeight(1f)
                    .padding(top = 20.dp)
                    .verticalScroll(rememberScrollState()),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ) {
                val emailTextState = remember { mutableStateOf(TextFieldValue("")) }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 20.dp),
                        text = "Forgot Password",
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 20.dp),
                        text = "Enter your valid email address below and we will send you email with instructions on how to change your password",
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Email Address*",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(bottom = 5.dp, top = 10.dp)
                    )

                    CustomStyleTextField(
                        placeHolder = "Email Address",
                        leadingIconId = Icons.Default.Email,
                        keyboardType = KeyboardType.Email,
                        keyboardCapitalization = KeyboardCapitalization.None,
                        imeAction = ImeAction.Done,
                        visualTransformation = VisualTransformation.None,
                        emailTextState.value
                    ) {
                        emailTextState.value = it
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    ElevatedButton(
                        onClick = {
                            if (emailTextState.value.text.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Please enter your email",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                //   navController.navigate("home")
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
                            text = "Send Email",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))


                }
            }
        }


    }
}