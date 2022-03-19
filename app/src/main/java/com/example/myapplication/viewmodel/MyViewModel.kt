package com.example.myapplication.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.myapplication.repository.StudentRepository

class MyViewModel(context: Context) : ViewModel() {
    private val studentRepository = StudentRepository(context)
    val students = studentRepository.students
}