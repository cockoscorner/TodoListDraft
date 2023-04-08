package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodoBinding

class TodoAdaptor(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdaptor.TodoViewHolder>() {
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    private lateinit var binding: ItemTodoBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val curTodo = todos[position]

        binding.tvTodoTitle.text = curTodo.title
        binding.cbDone.isChecked = curTodo.isChecked

    }

    override fun getItemCount(): Int {
        return todos.size
    }
}