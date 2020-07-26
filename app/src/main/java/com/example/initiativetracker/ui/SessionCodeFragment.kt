package com.example.initiativetracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.initiativetracker.R
import com.example.initiativetracker.databinding.FragmentSessionCodeEnterBinding
import com.example.initiativetracker.domain.Session
import com.example.initiativetracker.storage.SharedPrefManager
import com.example.initiativetracker.util.App
import kotlinx.android.synthetic.main.fragment_session_code_enter.btn_enter_session_code
import kotlinx.android.synthetic.main.fragment_session_code_enter.editTextSessionCode

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_enter_session_code.setOnClickListener { v: View ->
            SharedPrefManager.getInstance(App.applicationContext())
                .saveSession(Session(editTextSessionCode.editableText.toString(), ""))
            v.findNavController().navigate(R.id.action_session_code_enter_to_monsterListFragment)
        }
    }
}
