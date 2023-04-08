package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var todoAdapter: TodoAdaptor
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        todoAdapter = TodoAdaptor(mutableListOf())

        binding.rvToDoItems.adapter = todoAdapter
        binding.rvToDoItems.layoutManager = LinearLayoutManager(this)

        binding.btnAddToDo.setOnClickListener {
            val todoTitle = binding.etToDoTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                binding.etToDoTitle.text.clear()
            }
        }

        binding.btnDeleteToDo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}