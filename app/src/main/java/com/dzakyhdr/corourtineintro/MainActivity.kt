package com.dzakyhdr.corourtineintro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dzakyhdr.corourtineintro.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }

        binding.btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUser()
            }
        }

    }

    private fun downloadUser() {
        for (i in 1..200000){
            Log.i("MyTag","Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}