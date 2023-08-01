package com.example.digitmaster

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import android.widget.Toast
import com.example.digitmaster.databinding.ActivityBarcodeScannerBinding
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import java.io.IOException
import android.content.Intent
import android.net.Uri
import android.view.ScaleGestureDetector

class BarcodeScanner : AppCompatActivity() {

    private lateinit var binding :ActivityBarcodeScannerBinding
    private lateinit var barcodeDetector: BarcodeDetector
    private lateinit var cameraSource: CameraSource
    var intentData =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarcodeScannerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun iniBc(){
        barcodeDetector = BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.ALL_FORMATS).build()
        cameraSource = CameraSource.Builder(this,barcodeDetector).setRequestedPreviewSize(1920,1080).setAutoFocusEnabled(true).build()

        binding.surfaceView!!.holder.addCallback(object :SurfaceHolder.Callback{
            @SuppressLint("MissingPermission")
            override fun surfaceCreated(p0: SurfaceHolder) {
               try {
                   cameraSource.start(binding.surfaceView!!.holder)
               }catch (e: IOException){
                   e.printStackTrace()
                }
            }

            override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {

            }

            override fun surfaceDestroyed(p0: SurfaceHolder) {
                cameraSource.stop()
            }

        })
        barcodeDetector.setProcessor(object :Detector.Processor<Barcode>{
            override fun release() {
                Toast.makeText(applicationContext,"Barcode Scanner has been stopped",Toast.LENGTH_SHORT).show()
            }

            override fun receiveDetections(detections: Detector.Detections<Barcode>) {
               val barcodes = detections.detectedItems
                if(barcodes.size() !=0){
                    binding.txtBarcodeValue!!.post{
                        binding.btnAction!!.text = "SEARCH ITEM"
                        intentData = barcodes.valueAt(0).displayValue
                        binding.txtBarcodeValue.setText(intentData)
//                        finish()
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(intentData)
                        startActivity(intent)
                    }
                }
            }

        })
    }

    override fun onPause() {
        super.onPause()
        cameraSource!!.release()
    }

    override fun onResume() {
        super.onResume()
        iniBc()
    }
}