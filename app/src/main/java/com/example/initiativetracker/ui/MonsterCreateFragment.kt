package com.example.initiativetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.initiativetracker.R
import com.example.initiativetracker.databinding.FragmentMonsterCreateBinding
import com.example.initiativetracker.domain.Monster
import com.example.initiativetracker.network.RetrofitClient
import com.example.initiativetracker.storage.SharedPrefManager
import com.example.initiativetracker.util.App
import kotlinx.android.synthetic.main.fragment_monster_create.btn_create_monster
import kotlinx.android.synthetic.main.fragment_monster_create.editTextMonsterInitiative
import kotlinx.android.synthetic.main.fragment_monster_create.editTextMonsterName

class MonsterCreateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMonsterCreateBinding>(
            inflater,
            R.layout.fragment_monster_create,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_create_monster.setOnClickListener { v: View ->
            val monster = Monster(
                0,
                editTextMonsterName.editableText.toString(),
                editTextMonsterInitiative.editableText.toString().toInt(),
                SharedPrefManager.getInstance(App.applicationContext()).session.sessionId,
                0
            )
            RetrofitClient.instance.postNewMonster(
                SharedPrefManager.getInstance(App.applicationContext()).session.masterCode,
                monster
            )
            v.findNavController().navigate(R.id.action_monsterCreateFragment_to_monsterListFragment)
        }
    }
}
