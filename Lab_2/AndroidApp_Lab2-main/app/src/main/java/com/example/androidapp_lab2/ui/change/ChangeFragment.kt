package com.example.androidapp_lab2.ui.change

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidapp_lab2.databinding.FragmentChangeBinding
import com.example.androidapp_lab2.ui.change.ChangeViewModel

class ChangeFragment : Fragment() {

    private var _binding: FragmentChangeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val changeViewModel =
            ViewModelProvider(this).get(ChangeViewModel::class.java)

        _binding = FragmentChangeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textChange
        changeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}