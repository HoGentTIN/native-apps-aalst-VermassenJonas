package com.example.initiativetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.initiativetracker.R
import com.example.initiativetracker.databinding.FragmentChooseModeBinding
import kotlinx.android.synthetic.main.fragment_choose_mode.btn_choose_join

class ChooseModeFragment : Fragment() {

    lateinit var btn_join: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_join = btn_choose_join
        btn_join.setOnClickListener { v: View ->

            v.findNavController()
                .navigate(R.id.action_choose_mode_to_session_code_enter)
        }
    }
}
