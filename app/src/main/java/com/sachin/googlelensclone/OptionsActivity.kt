package com.sachin.googlelensclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sachin.googlelensclone.barcode.BarcodeActivity
import com.sachin.googlelensclone.text.TextRecognitionActivity
import kotlinx.android.synthetic.main.activity_options.*

class OptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
/*btn barcode is actually for recognition*/
        btnLabeler.setOnClickListener {
            startActivity(Intent(this, BarcodeActivity::class.java))
        }

//        btnLabel.setOnClickListener {
//            startActivity(Intent(this,BarcodeActivity::class.java))
//        }

        btnTextR.setOnClickListener {
            startActivity(Intent(this,TextRecognitionActivity::class.java))
        }

    }

}