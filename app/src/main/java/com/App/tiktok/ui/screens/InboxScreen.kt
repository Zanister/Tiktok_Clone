package com.App.tiktok.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InboxScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(5) { messageIndex ->
            Text(
                text = "Message $messageIndex",
                fontSize = 20.sp,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
