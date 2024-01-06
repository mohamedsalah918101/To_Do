package com.petra.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(private val items: List<ToDo>) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>(){

    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val taskTextView: TextView = itemView.findViewById(R.id.textTask)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoAdapter.ToDoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoAdapter.ToDoViewHolder, position: Int) {
        val currentItem = items[position]
        holder.taskTextView.text = currentItem.task
    }

    override fun getItemCount(): Int {
        return items.size
    }


}