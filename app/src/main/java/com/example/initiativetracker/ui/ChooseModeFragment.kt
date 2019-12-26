package com.example.initiativetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.initiativetracker.R
import com.example.initiativetracker.databinding.FragmentChooseModeBinding


class ChooseModeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentChooseModeBinding>(
            inflater,
            R.layout.fragment_choose_mode,
            container,
            false
        )
        return binding.root
    }
}