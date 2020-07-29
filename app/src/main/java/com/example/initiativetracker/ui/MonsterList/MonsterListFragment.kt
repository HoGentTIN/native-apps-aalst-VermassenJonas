package com.example.initiativetracker.ui.MonsterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.initiativetracker.R
import com.example.initiativetracker.databinding.FragmentMonsterListBinding
import com.example.initiativetracker.domain.Monster
import com.example.initiativetracker.storage.SharedPrefManager
import com.example.initiativetracker.util.App
import com.example.initiativetracker.util.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_monster_list.fab_create_monster

class MonsterListFragment : Fragment() {

    private lateinit var viewModel: MonsterListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMonsterListBinding>(
            inflater,
            R.layout.fragment_monster_list,
            container,
            false
        )

        val application = requireNotNull(this.activity).application
        val viewModelFactory =
            MonsterListViewModelFactory(application)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(MonsterListViewModel::class.java)

        val listener = object : OnItemClickListener<Monster> {
            override fun onItemClick(item: Monster) {
                viewModel.onSetMonster(item)
            }
        }
        val adapter = MonsterListAdapter(listener)
        binding.monsterList.adapter = adapter
        viewModel.monsters.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title =
            "Session " + SharedPrefManager.getInstance(App.applicationContext()).session.sessionId
        if ("" == SharedPrefManager.getInstance(App.applicationContext()).session.masterCode) {
            fab_create_monster.hide()
        } else {
            fab_create_monster.setOnClickListener { v: View ->
                v.findNavController()
                    .navigate(R.id.action_monsterListFragment_to_monsterCreateFragment)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onRefresh()
    }
}
