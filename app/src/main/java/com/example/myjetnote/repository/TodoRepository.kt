package com.example.myjetnote.repository

import com.example.myjetnote.datasource.TodoDAO
import com.example.myjetnote.model.ToDo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class TodoRepository @Inject constructor(private val todoDAO: TodoDAO){

    fun getAllTasks() : Flow<List<ToDo>> = flow {
        todoDAO.getAllTodosDistinctUntilChanged().collect {
            emit(it)
        }
    }


    suspend fun insertTodo(todo: ToDo) = todoDAO.insertTodo(todo)

}