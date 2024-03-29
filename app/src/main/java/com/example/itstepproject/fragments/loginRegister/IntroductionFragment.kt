package com.example.itstepproject.fragments.loginRegister

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.itstepproject.R
import com.example.itstepproject.databinding.FragmentIntrodcutionBinding

class IntroductionFragment: Fragment(R.layout.fragment_introdcution) {
    private  lateinit var binding: FragmentIntrodcutionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIntrodcutionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startBtn.setOnClickListener{
            findNavController().navigate(R.id.accountOptionsFragment)
        }
    }
}