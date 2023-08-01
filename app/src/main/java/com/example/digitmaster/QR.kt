package com.example.digitmaster

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.digitmaster.databinding.ActivityQrBinding

class QR : AppCompatActivity() {

    private var requestCamera:ActivityResultLauncher<String>? = null
    private lateinit var binding: ActivityQrBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQrBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestCamera = registerForActivityResult(ActivityResultContracts.RequestPermission(),){
            if(it){
                val intent = Intent(this,BarcodeScanner::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Permission Not Granted !!", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnBc.setOnClickListener() {
            requestCamera?.launch(android.Manifest.permission.CAMERA)
        }
    }
}