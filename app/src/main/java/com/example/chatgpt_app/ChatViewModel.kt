package com.example.chatgpt_app

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    val messages = mutableStateListOf<Message>()

    fun sendMessage(text: String, isUser: Boolean = true) {
        val newMessage = Message(text, if (isUser) "user" else "system")
        messages.add(newMessage)
        if (isUser) {
            viewModelScope.launch {
                try {
                    val response = ApiService.openAIApi.generateResponse(OpenAIRequestBody(messages = messages))
                    messages.add(response.choices.first().message)
                } catch (e: Exception) {
                    // Handle the error appropriately
                    messages.add(Message("Error: ${e.message}", "system"))
                }
            }
        }
    }
}
