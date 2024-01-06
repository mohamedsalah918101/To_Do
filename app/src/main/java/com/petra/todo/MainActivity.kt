package com.petra.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextToDo: EditText
    private lateinit var btnInsert: Button
    private lateinit var btnUpdate: Button
    private lateinit var recyclerViewToDo: RecyclerView
    private lateinit var toDoList: MutableList<ToDo>
    private lateinit var adapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextToDo = findViewById(R.id.editTextToDo)
        btnInsert = findViewById(R.id.btnInsert)
        btnUpdate = findViewById(R.id.btnUpdate)
        recyclerViewToDo = findViewById(R.id.recyclerViewToDo)

        toDoList = mutableListOf()
        adapter = ToDoAdapter(toDoList)
        recyclerViewToDo.adapter = adapter
        recyclerViewToDo.layoutManager = LinearLayoutManager(this)

        btnInsert.setOnClickListener {
            InserToDo()
        }

        btnUpdate.setOnClickListener{
            toDoList.clear()
            adapter.notifyDataSetChanged()
        }
    }
    private fun InserToDo(){
        val task = editTextToDo.text.toString().trim()
        if (task.isNotEmpty()) {
            toDoList.add(ToDo(task))
            adapter.notifyDataSetChanged()
            editTextToDo.text.clear()
        }
        else {
            Toast.makeText(this, "Please Enter a Task", Toast.LENGTH_SHORT).show()
        }
    }
}