package com.example.listanggotahima

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnggota: RecyclerView
    private val list = ArrayList<Anggota>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnggota = findViewById(R.id.rv_anggota)
        rvAnggota.setHasFixedSize(true)

        val btnAbout: ImageButton = findViewById(R.id.btnAbout)
        btnAbout.setOnClickListener {
            val intent = Intent(this, About::class.java)
            startActivity(intent)
        }

        list.addAll(getListHeroes())
        showRecyclerList()
    }

    private fun getListHeroes(): ArrayList<Anggota> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataJabatan = resources.getStringArray(R.array.data_jabatan)
        val listHero = ArrayList<Anggota>()
        for (i in dataName.indices) {
            val hero = Anggota(dataName[i],dataJabatan[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvAnggota.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListAnggotaAdapter(list)
        rvAnggota.adapter = listHeroAdapter
    }
}
