package com.example.android.tour_guide_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.tour_guide_app.databinding.FragmentPageBinding

const val ARG_OBJECT = "object"

class Component : Fragment() {
    private lateinit var binding: FragmentPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            binding.test.text = getInt(ARG_OBJECT).toString()
        }
    }
}
