package com.sachin.googlelensclone

import android.bluetooth.BluetoothAdapter.ERROR
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_IMAGE_CAPTURE = 1
    val data="some_data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTakePic.setOnClickListener{
            val takePhotoIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try {
            startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE)
            } catch (e: ActivityNotFoundException) {
                Log.d("Cam","camera not found error")
            }
        }
        btnML.setOnClickListener{
            val mlIntent=Intent(this,OptionsActivity::class.java)
            startActivity(mlIntent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            ivPic.setImageBitmap(imageBitmap)
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}