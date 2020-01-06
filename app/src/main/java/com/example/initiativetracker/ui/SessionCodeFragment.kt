package com.example.initiativetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.initiativetracker.R
import com.example.initiativetracker.databinding.FragmentSessionCodeEnterBinding

class SessionCodeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSessionCodeEnterBinding>(
            inflater,
            R.layout.fragment_session_code_enter,
            container,
            false
        )
        return binding.root
    }
}
