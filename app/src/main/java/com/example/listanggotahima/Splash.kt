package com.example.listanggotahima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashh)
        // Menggunakan Handler untuk menjalankan kode setelah waktu tertentu
        Handler().postDelayed({
            // Aksi yang akan dijalankan setelah waktu tampilan splash selesai
            val homeIntent = Intent(this@Splash, MainActivity::class.java) // Ganti MainActivity dengan activity tujuan Anda
            startActivity(homeIntent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}