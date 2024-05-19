package com.example.chatgpt_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatgpt_app.ui.theme.ChatGPT_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatGPT_AppTheme {
                val chatViewModel = viewModel<ChatViewModel>()
                ChatScreen(chatViewModel)
            }
        }
    }
}
