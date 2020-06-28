package com.juliuskrah.template.ui.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.juliuskrah.template.databinding.FragmentOneBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OneFragment : Fragment() {

    private var _binding: FragmentOneBinding? = null
    private val binding get() = _binding!!
    private val oneViewModel: OneViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        oneViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textOne.text = it
        })
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}