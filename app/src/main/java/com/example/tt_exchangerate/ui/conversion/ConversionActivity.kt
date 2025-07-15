package com.example.tt_exchangerate.ui.conversion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tt_exchangerate.databinding.ActivityConversionBinding

class ConversionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConversionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConversionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val abbreviation = intent.getStringExtra("abbreviation") ?: "???"
        val course = intent.getDoubleExtra("course", 0.0)

        binding.abbreviationTV.text = abbreviation
        binding.outCount.text = "Текущий курс: $course"

        binding.buttonConvert.setOnClickListener {
            val input = binding.inCount.text.toString()
            if (input.isNotBlank()) {
                val amount = input.toDoubleOrNull() ?: 0.0
                val result = amount * course
                binding.outCount.text = "Результат: $result ₽"
            }
        }

        binding.buttonHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}