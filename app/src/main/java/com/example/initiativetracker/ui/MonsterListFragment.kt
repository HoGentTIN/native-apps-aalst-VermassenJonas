package com.example.initiativetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.initiativetracker.R
import com.example.initiativetracker.domain.Monster
import com.example.initiativetracker.util.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_monster_list.monster_list

class MonsterListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_monster_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        monster_list.layoutManager = LinearLayoutManager(this.context)
        val listener = object : OnItemClickListener<Monster> {
            override fun onItemClick(item: Monster) {
                // TODO
            }
        }
        monster_list.adapter = MonsterListAdapter(listener)
    }
}
