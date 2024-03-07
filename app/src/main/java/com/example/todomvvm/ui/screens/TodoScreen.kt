package com.example.todomvvm.ui.screens
import android.util.Log
import androidx.compose.runtime.Composable
import com.example.todomvvm.ui.components.TodoList
import viewmodel.TodoUiState

@Composable
fun TodoScreen(uiState: TodoUiState) {
    Log.d("TodoScreen", "TodoScreen: $uiState")
    when (uiState) {
        is TodoUiState.Loading -> LoadingScreen("Loading...")
        is TodoUiState.Error -> ErrorScreen("Error in retrieving data from the server")
        is TodoUiState.Success -> TodoList(uiState.todos)
    }
}