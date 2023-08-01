package com.example.digitmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.digitmaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var calculator: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculator = findViewById(R.id.calculator)

        calculator.setOnClickListener {
            var intent = Intent(this,DigitMaster::class.java)
            startActivity(intent)
        }
    }
}