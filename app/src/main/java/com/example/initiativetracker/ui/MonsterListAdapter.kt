package com.example.initiativetracker.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.initiativetracker.domain.Monster

class MonsterListAdapter :
    ListAdapter<Monster, MonsterListAdapter.MonsterViewHolder>(DiffCallback()) {

    class MonsterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonsterViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MonsterViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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