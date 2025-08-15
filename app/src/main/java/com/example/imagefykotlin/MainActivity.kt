package com.example.imagefykotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imagefykotlin.R.drawable.ic_launcher_background
import com.example.imagefykotlin.R.drawable.ic_launcher_foreground
import com.example.imagefykotlin.databinding.ActivityMainBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.button.setOnClickListener {
            Picasso.get().load("https://dummyjson.com/image/150").into(
                binding.img, object : Callback{
                    override fun onError(e: Exception?) {
                        binding.pBar.visibility = View.VISIBLE
                        Toast.makeText(this@MainActivity, "Something went wrong!!!", Toast.LENGTH_LONG).show()
                    }

                    override fun onSuccess() {
                        binding.pBar.visibility = View.INVISIBLE
                        Toast.makeText(this@MainActivity, "Success!!!", Toast.LENGTH_LONG).show()
                    }
                }
            )
        }
    }
}