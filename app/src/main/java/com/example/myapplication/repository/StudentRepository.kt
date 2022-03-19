package com.example.myapplication.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.example.myapplication.room.AppDatabase
import com.example.myapplication.room.Student

class StudentRepository(context: Context) {

    private val dao = AppDatabase.getInstance(context).studentDao
    var students: LiveData<PagedList<Student>> = dao.getAllStudents().toLiveData(pageSize = 50)

}