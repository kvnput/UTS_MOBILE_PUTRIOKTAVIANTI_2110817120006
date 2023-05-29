package com.putrioktavianti.Album

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SoloAdapter(val data: List<Player>) : RecyclerView.Adapter<SoloAdapter.MyViewHolder>() {

    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
        val textView1 = row.findViewById<TextView>(R.id.nama)
        val imageView = row.findViewById<ImageView>(R.id.image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.album_item,
            parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView1.text = data.get(position).nama
        holder.imageView.setImageResource(data.get(position).gambar)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val model = data.get(position)
            val gambar: Int = model.gambar
            val nama : String = model.nama
            val deskrpsi = model.deskripsi
            val album = model.album

            //Membuat Intent

            val intent = Intent(context, SoloActivity::class.java)
            //Putextra
            intent.putExtra("Nama", nama)
            intent.putExtra("Gambar" , gambar)
            intent.putExtra("Deskripsi", deskrpsi)
            intent.putExtra("Album", album)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = data.size
}