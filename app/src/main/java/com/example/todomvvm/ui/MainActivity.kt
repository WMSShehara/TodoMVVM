package com.example.todomvvm.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todomvvm.ui.components.TodoList
import com.example.todomvvm.ui.screens.ErrorScreen
import com.example.todomvvm.ui.screens.LoadingScreen
import com.example.todomvvm.ui.theme.TodoMVVMTheme
import viewmodel.TodoUiState
import viewmodel.TodoViewmodel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoScreen()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoScreen(todoViewModel: TodoViewmodel= viewModel()) {
   // val todos = todoViewmodel.todos
    TodoScreen(uiState = todoViewModel.todoUiState)
    Scaffold(
        topBar = { TopAppBar(
            title = { Text("Todo List") }
        )
        },
        content = {
            TodoScreen(uiState = todoViewModel.todoUiState)
            Log.d("TodoApp", "TodoApp: ${todoViewModel.todoUiState}")
        }
    )

}
@Composable
fun TodoScreen(uiState: TodoUiState) {
    //Log.d("TodoScreen", "TodoScreen: $uiState")
    when (uiState) {
        is TodoUiState.Loading -> LoadingScreen()
        is TodoUiState.Error -> ErrorScreen()
        is TodoUiState.Success -> TodoList(uiState.todos)
    }
}
/*@Composable
fun TodoList(todos:List<Todo>) {
    LazyColumn(
        modifier= Modifier.padding(8.dp)
    ){
        items(todos){ todo->
            Text(
                text = todo.title,
                modifier=Modifier.padding(top=4.dp,bottom=4.dp)
            )
            Divider(color= Color.LightGray, thickness=1.dp)
        }
    }
}*/

@Preview(showBackground = true)
@Composable
fun TodoScreenPreview() {
    TodoMVVMTheme {
        TodoScreen()
    }
}