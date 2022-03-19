package com.example.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityCreateStudentBinding
import com.example.myapplication.room.AppDatabase
import com.example.myapplication.room.Student
import kotlinx.coroutines.launch

class CreateStudent : AppCompatActivity() {

    private lateinit var binding: ActivityCreateStudentBinding
    val dao = AppDatabase.getInstance(this).studentDao

    private var name: String? = null
    private var id: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateStudentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.createStudent.setOnClickListener {
            name = binding.inputName.text.toString()
            id = binding.inputId.text.toString()
            lifecycleScope.launch {
                dao.insertStudent(Student(name = name!!, studentId = id!!))
            }
            finish()
        }
    }
}