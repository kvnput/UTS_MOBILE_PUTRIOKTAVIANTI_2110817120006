package com.putrioktavianti.Album

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class GrupActivity : AppCompatActivity() {
    companion object {
        const val SEARCH_PREFIX = "https://open.spotify.com/search/"
        const val SEARCH = "https://www.youtube.com/results?search_query="
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_grup)

        val namaDiLayout = findViewById<TextView>(R.id.tv_nama)
        val deskripsiDiLayout = findViewById<TextView>(R.id.tv_item_description)
        val albumDiLayout = findViewById<TextView>(R.id.tv_item_album)
        val gambarDiLayout = findViewById<ImageView>(R.id.img_item_photo)
        val buttonn = findViewById<Button>(R.id.button_id)
        val button2 = findViewById<Button>(R.id.button2_id)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        //get data from putExtra
        var intent = intent
        val nama = intent.getStringExtra("Nama")
        val gambar = intent.getIntExtra("Gambar", 0)
        val deskripsi = intent.getStringExtra("Deskripsi")
        val album = intent.getStringExtra("Album")


        actionBar.setTitle(nama)
        namaDiLayout.text = nama


        deskripsiDiLayout.text = deskripsi
        gambarDiLayout.setImageResource(gambar)
        albumDiLayout.text = album

        buttonn.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${SoloActivity.SEARCH_PREFIX}${nama}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${SoloActivity.SEARCH}${nama}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            startActivity(intent)
        }

    }
}