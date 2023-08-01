package com.example.digitmaster

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.digitmaster.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var calculator: TextView
    private lateinit var qr: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculator = findViewById(R.id.calculator)
        qr = findViewById(R.id.qr)

        calculator.setOnClickListener {
            var intent = Intent(this,DigitMaster::class.java)
            startActivity(intent)
        }
        qr.setOnClickListener {
            var intent = Intent(this,QR::class.java)
            startActivity(intent)
        }
    }
}