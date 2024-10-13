package com.App.tiktok.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(onLoginClick: () -> Unit) {
    var email by remember { mutableStateOf("") }  // State for email input
    var password by remember { mutableStateOf("") }  // State for password input
    var isLoading by remember { mutableStateOf(false) }  // Loading state
    val coroutineScope = rememberCoroutineScope()  // Coroutine scope for handling async behavior

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Log in",
                fontSize = 22.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email,  // Bind state to input
                onValueChange = { email = it },
                label = { Text("Email or username") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,  // Bind state to input
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Forgot password?",
                color = Color.Gray,
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    coroutineScope.launch {
                        isLoading = true
                        delay(2000)  // Simulate login delay for 2 seconds
                        onLoginClick()
                        isLoading = false
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(24.dp),
                enabled = !isLoading  // Disable button when loading
            ) {
                if (isLoading) {
                    CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
                } else {
                    Text(text = "Log in")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Don't have an account? Sign up",
                color = Color.Gray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
