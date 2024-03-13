package com.example.todomvvm.ui.screens
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import model.Todo

//@Composable
/*fun TodoScreen(uiState: TodoUiState) {
    Log.d("TodoScreen", "TodoScreen: $uiState")
    when (uiState) {
        is TodoUiState.Loading -> LoadingScreen("Loading...")
        is TodoUiState.Error -> ErrorScreen("Error in retrieving data from the server")
        is TodoUiState.Success -> TodoList(uiState.todos)
    }
}*/
@Composable
fun LoadingScreen(){
    Text(text = "Loading...")
}
@Composable
fun ErrorScreen(){
    Text(text = "Error in retrieving data from the server")
}
@Composable
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
}