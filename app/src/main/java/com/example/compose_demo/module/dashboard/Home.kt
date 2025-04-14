package com.example.compose_demo.module.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.compose_demo.R
import com.example.compose_demo.ui.composables.CustomStyleTextField

@Composable
fun HomePage() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val searchTextState = remember { mutableStateOf(TextFieldValue("")) }


        Column(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp),
                modifier = Modifier
                    .fillMaxHeight(.25f)
                    .verticalScroll(rememberScrollState()),
                colors = CardDefaults.cardColors(
                    containerColor =
                        MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(14.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start
                ) {


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "Welcome back!",
                                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(top = 5.dp)
                            )
                            Text(
                                text = "Dharmendra Kumar",
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier.padding(bottom = 5.dp)
                            )
                        }

                        Image(
                            modifier = Modifier
                                .size(50.dp)
                                .clip(shape = RoundedCornerShape(50.dp)),
                            alignment = Alignment.TopEnd,
                            painter = painterResource(id = R.drawable.user),
                            contentDescription = "user"
                        )
                    }
                    Text(
                        text = "Find your 100+ Jobs",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                        modifier = Modifier.padding(top = 15.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    CustomStyleTextField(
                        placeHolder = "Search a job or position...",
                        keyboardType = KeyboardType.Text,
                        keyboardCapitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Done,
                        visualTransformation = VisualTransformation.None,
                        textState = searchTextState.value,
                        leadingIconId = Icons.Default.Search,
                    ) {
                        searchTextState.value = it
                    }

                }

            }
            Column(
                modifier = Modifier
                    .fillMaxHeight(1f)
            ) {

            }

        }
    }
}