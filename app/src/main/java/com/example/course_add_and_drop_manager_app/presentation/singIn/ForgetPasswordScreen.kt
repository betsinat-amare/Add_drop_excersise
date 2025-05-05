package com.example.course_add_and_drop_manager_app.presentation.singIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.course_add_and_drop_manager_app.Course_add_and_drop_managerAppRoute
import com.example.course_add_and_drop_manager_app.Screen
import com.example.course_add_and_drop_manager_app.presentation.components.SystemBackButtonHandler
import com.example.course_add_and_drop_manager_app.ui.theme.colorGrayBackground
import com.example.course_add_and_drop_manager_app.ui.theme.colorPrimary
import java.time.format.TextStyle

@Composable
fun ForgetPasswordScreen(
    onResetClick: (String) -> Unit = {},
    onBackToLoginClick: () -> Unit = {
        Course_add_and_drop_managerAppRoute.navigateTo(Screen.LoginScreen)
    }
){
    var email by remember { mutableStateOf("") }

    val onBack: () -> Unit = {
        Course_add_and_drop_managerAppRoute.navigateTo(Screen.LoginScreen)
    }

    SystemBackButtonHandler {
        onBack()
    }
    Surface(
        color = colorGrayBackground,
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFE0E7FF))
            .padding(top = 20.dp),
    ) {
        Column {
            // Back Icon
            IconButton(onClick = { onBack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Forgot Password?",
                    style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp),
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Text(
                    text = "Enter your registered email to receive reset instructions.",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    placeholder = { Text("you@example.com") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )

                Button(

                    onClick = { onResetClick(email) },
                    colors = ButtonDefaults.buttonColors(containerColor = colorPrimary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Text("Reset Password")
                }

                TextButton(onClick = { onBackToLoginClick() }) {
                    Text("Back to Login",color= colorPrimary)
                }
            }
        }
    }
        }