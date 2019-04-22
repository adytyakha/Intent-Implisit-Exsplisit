package com.adytyakha.intentimplisiteksplisit

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kotlinx.android.synthetic.main.activity_implisit_intent.*

class ImplisitIntent : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implisit_intent)

        //  ketik disini eaaa
        btnCapture.setOnClickListener {
            dispatchTakePictureIntent()

        }

        btnsms.setOnClickListener {
            sms()
        }
        btnPhone.setOnClickListener {
            phone()
        }

        btnGmap.setOnClickListener {
            maps()
        }
        btnig.setOnClickListener {
            ig(it)
        }
        btnyt.setOnClickListener {
            yt(it)
        }

    }

    // Play Message
    fun sms(){
        val uri = Uri.parse("smsto:082322738645")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("Adit ", "Jangan Lupa Bahagia")
        startActivity(intent)
    }

    // play Phone
    fun phone(){
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "082322738645"))
        startActivity(intent)
    }

    // play Google Maps Nav
    fun maps(){
        val intent = Intent(
            android.content.Intent.ACTION_VIEW,
            Uri.parse("google.navigation:q=" + tvMaps.text)
        )
        startActivity(intent)
    }

    // ig
    fun ig(view: View) {
        val url = "https://www.instagram.com/adytya_kha"
        val igbrowser = Intent(Intent.ACTION_VIEW)
        igbrowser.data = Uri.parse(url)
        startActivity(igbrowser)
    }

    // yt
    fun yt(view: View) {
        val url = "https://www.youtube.com"
        val ytbrowser = Intent(Intent.ACTION_VIEW)
        ytbrowser.data = Uri.parse(url)
        startActivity(ytbrowser)
    }
    // play Camera
    fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }




    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            iv.setImageBitmap(imageBitmap)
        }
    }


}
