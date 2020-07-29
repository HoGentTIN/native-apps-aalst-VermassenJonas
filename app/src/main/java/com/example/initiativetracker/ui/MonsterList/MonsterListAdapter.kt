package com.example.initiativetracker.ui.MonsterList

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.initiativetracker.databinding.ListItemMonsterBinding
import com.example.initiativetracker.domain.Monster
import com.example.initiativetracker.ui.MonsterList.MonsterListAdapter.ViewHolder.Companion.from
import com.example.initiativetracker.util.OnItemClickListener

class MonsterListAdapter(val listener: OnItemClickListener<Monster>) :
    ListAdapter<Monster, MonsterListAdapter.ViewHolder>(
        DiffCallback()
    ) {

    class ViewHolder private constructor(val binding: ListItemMonsterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Monster, listener: OnItemClickListener<Monster>) {
            binding.monster = item
            itemView.setOnClickListener {
                listener.onItemClick(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemMonsterBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val monster = getItem(position)
        holder.bind(monster, listener)
    }

    class DiffCallback : DiffUtil.ItemCallback<Monster>() {
        override fun areItemsTheSame(oldItem: Monster, newItem: Monster): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Monster, newItem: Monster): Boolean {
            return oldItem == newItem
        }
    }
}

@BindingAdapter("monsterInitiative")
fun TextView.setMonsterInitiative(item: Monster) {
    text = item.initiative.toString()
}
