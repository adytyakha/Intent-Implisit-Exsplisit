package com.adytyakha.intentimplisiteksplisit

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import com.kotlinpermissions.KotlinPermissions
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        KotlinPermissions.with(this) // where this is an FragmentActivity instance
            .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.CAMERA,
                Manifest.permission.SEND_SMS,
                Manifest.permission.CALL_PHONE
            )
            .onAccepted { permissions ->
                Toast.makeText(this, "Accesed" + BuildConfig.APPLICATION_ID, Toast.LENGTH_LONG).show()
            }
            .onDenied { permissions ->
                Toast.makeText(this, "Denied", Toast.LENGTH_LONG).show()
            }
            .onForeverDenied { permissions ->
                //List of forever denied permissions
            }
            .ask()

        //ketik disini

        btnPindahExplisitIntent.setOnClickListener {
            startActivity(Intent(this, ExplisitIntent::class.java))
        }

        btnPindahImplisitIntent.setOnClickListener {
            startActivity(Intent(this, ImplisitIntent::class.java))
        }


    }


}
