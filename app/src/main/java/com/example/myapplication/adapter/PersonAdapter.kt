package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.*
import com.example.myapplication.R
import com.example.myapplication.adapter.StudentAdapter.*
import com.example.myapplication.room.Student

class StudentAdapter : PagedListAdapter<Student, MyViewHolder>(DIFF_CALLBACK) {

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        val txtName = itemView.findViewById<TextView>(R.id.fullName)
        val txtId = itemView.findViewById<TextView>(R.id.studentId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.name_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val student: Student? = getItem(position)
        holder.txtName.text = student?.name
        holder.txtId.text = student?.studentId
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Student>() {
            // The ID property identifies when items are the same.
            override fun areItemsTheSame(oldItem: Student, newItem: Student) =
                oldItem.id == newItem.id

            // If you use the "==" operator, make sure that the object implements
            // .equals(). Alternatively, write custom data comparison logic here.
            override fun areContentsTheSame(
                oldItem: Student, newItem: Student
            ) = oldItem == newItem
        }
    }
}