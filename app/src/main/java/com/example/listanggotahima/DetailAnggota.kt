package com.example.listanggotahima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailAnggota : AppCompatActivity() {

    private lateinit var nama: TextView
    private lateinit var deskripsi: TextView
    private lateinit var img: ImageView
    private lateinit var receivedAnggota: Anggota // Fungsinya Menyimpan objek Anggota yang diterima
    private lateinit var btnShare: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_anggota)

        // Fungsinya Untuk Menerima objek Anggota yang dikirim melalui Intent
        receivedAnggota = intent.getParcelableExtra("key_anggota")!!

        // Fungsinya Inisialisasi komponen UI
        nama = findViewById(R.id.namadetail)
        deskripsi = findViewById(R.id.deskripsidetail)
        img = findViewById(R.id.fotodetail)
        btnShare = findViewById(R.id.action_share)

        // Fungsinya Mengatur nilai komponen UI dengan data yang diterima
        nama.text = receivedAnggota.nama
        deskripsi.text = receivedAnggota.deskripsi



        // Fungsinya Menggunakan Glide untuk memuat gambar dari URL atau resource
        Glide.with(this@DetailAnggota)
            .load(receivedAnggota.foto)
            .apply(RequestOptions().override(370, 370))
            .into(img)

        btnShare.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Share this with someone: ${receivedAnggota.nama}")
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }
}
