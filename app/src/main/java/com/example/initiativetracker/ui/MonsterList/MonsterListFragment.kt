package com.example.initiativetracker.ui.MonsterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
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

        val application = requireNotNull(this.activity).application
        val viewModelFactory =
            MonsterListViewModelFactory(application)
        val viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MonsterListViewModel::class.java)

        val listener = object : OnItemClickListener<Monster> {
            override fun onItemClick(item: Monster) {
                // TODO
            }
        }
        monster_list.adapter =
            MonsterListAdapter(
                listener
            )
    }
}
