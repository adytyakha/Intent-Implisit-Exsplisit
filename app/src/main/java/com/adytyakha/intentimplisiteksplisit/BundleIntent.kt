package com.adytyakha.intentimplisiteksplisit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bundle_intent.*

class BundleIntent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bundle_intent)


        val nama = intent.getStringExtra("Nama")
        val alamat = intent.getStringExtra("Alamat")
        val sekolah = intent.getStringExtra("Sekolah")
        val pekerjaan = intent.getStringExtra("Pekerjaan")
        val km = intent.getStringExtra("KM")

        tvnama.text = nama
        tvalamat.text = alamat
        tvsekolah.text = sekolah
        tvpekerjaan.text = pekerjaan
        tvkm.text = km


    }
}
