package model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Todo (
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)
const val BASE_URL = "https://jsonplaceholder.typicode.com/todos"

interface TodoApi{
    @GET("todos")
    suspend fun getTodos(): List<Todo>

    companion object {
        var todosService: TodoApi? = null
        fun getInstance(): TodoApi {
            if (todosService == null) {
                todosService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodoApi::class.java)
            }
            return todosService!!
        }
    }
}