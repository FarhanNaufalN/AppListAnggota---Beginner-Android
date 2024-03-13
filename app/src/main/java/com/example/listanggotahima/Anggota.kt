package com.example.listanggotahima

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anggota(
    val nama: String,
    val jabatan : String,
    val deskripsi: String,
    val foto: Int
) : Parcelable
