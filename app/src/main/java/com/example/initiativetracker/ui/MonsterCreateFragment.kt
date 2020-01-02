package com.example.initiativetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.initiativetracker.R
import com.example.initiativetracker.databinding.FragmentMonsterCreateBinding

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
}