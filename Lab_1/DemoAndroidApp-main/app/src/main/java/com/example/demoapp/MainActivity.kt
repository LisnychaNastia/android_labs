package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.demoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var simpleViewModel: SimpleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener(this)
        simpleViewModel = ViewModelProvider(this)[SimpleViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        //binding.tv1.text = simpleViewModel.str
    }

    override fun onClick(v: View?) {
        simpleViewModel.modifier()
        binding.tv1.text = simpleViewModel.str
    }
}