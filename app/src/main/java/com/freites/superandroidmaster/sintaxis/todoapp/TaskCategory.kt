package com.freites.superandroidmaster.sintaxis.todoapp

sealed class TaskCategory  {
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other : TaskCategory()
}