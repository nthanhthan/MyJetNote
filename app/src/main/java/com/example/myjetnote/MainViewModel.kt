package com.example.myjetnote

import androidx.lifecycle.*
import com.example.myjetnote.model.ToDo
import com.example.myjetnote.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: TodoRepository): ViewModel() {

    val listTodos : Flow<List<ToDo>> = flow {
        repository.getAllTasks().collect {
            emit(it)
        }
    }

    suspend fun insertTodo(toDo: ToDo){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertTodo(toDo)
        }
    }
}