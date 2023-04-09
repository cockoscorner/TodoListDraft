package com.example.todolist

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodoBinding

class TodoAdaptor(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdaptor.TodoViewHolder>() {
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    private lateinit var bindingTA: ItemTodoBinding
    private lateinit var viewTA: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        viewTA = LayoutInflater.from(parent.context).inflate(
            R.layout.item_todo,
            parent,
            false
        )
        return TodoViewHolder(
            viewTA
        )
    }

    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneTodos() {
        todos.removeAll { todo ->
            todo.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvTodoTitle.paintFlags = STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val curTodo = todos[position]
        bindingTA = ItemTodoBinding.bind(viewTA)
        bindingTA.tvTodoTitle.text = curTodo.title
        bindingTA.cbDone.isChecked = curTodo.isChecked

        toggleStrikeThrough(bindingTA.tvTodoTitle, curTodo.isChecked)
        bindingTA.cbDone.setOnCheckedChangeListener { _, isChecked ->
            toggleStrikeThrough(bindingTA.tvTodoTitle, isChecked)
        }

    }

    override fun getItemCount(): Int {
        return todos.size
    }
}