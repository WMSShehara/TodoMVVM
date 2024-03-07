package viewmodel
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import model.Todo
import model.TodoApi

sealed interface TodoUiState {
    data class Success(val todos: List<Todo>): TodoUiState
    object Error: TodoUiState
    object Loading: TodoUiState
}

class TodoViewmodel:ViewModel(){
    //var todos = mutableListOf<Todo>()
    var todoUiState: TodoUiState by mutableStateOf<TodoUiState>(TodoUiState.Loading)

    init {
        getTodoList()
    }
    private fun getTodoList(){
        viewModelScope.launch{
            var todosApi: TodoApi? = null
            try{
                todosApi = TodoApi!!.getInstance()
                //todos.clear()
                //todos.addAll(todosApi.getTodos())
                todoUiState = TodoUiState.Success(todosApi.getTodos())
                }catch (e:Exception){
                    Log.d("TodoViewmodel", e.message.toString())
                    todoUiState = TodoUiState.Error
                }
        }
    }
}