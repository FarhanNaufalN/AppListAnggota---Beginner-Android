package com.example.listanggotahima

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAnggotaAdapter(private val listAnggota: ArrayList<Anggota>) : RecyclerView.Adapter<ListAnggotaAdapter.ListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_anggota, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listAnggota.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (nama, jabatan, deskripsi, foto) = listAnggota[position]
        holder.imgPhoto.setImageResource(foto)
        holder.tvName.text = nama
        holder.tvJabatan.text = jabatan
        holder.tvDescription.text = deskripsi
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailAnggota::class.java)
            intentDetail.putExtra("key_anggota", listAnggota[position])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvJabatan: TextView = itemView.findViewById(R.id.tv_item_jabatan)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_detail)
    }


}


