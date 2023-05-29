package com.putrioktavianti.Album.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.putrioktavianti.Album.R
import com.putrioktavianti.Album.SoloAdapter
import com.putrioktavianti.Album.AlbumGrup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GrupFragment : Fragment() {
    private lateinit var adapter: SoloAdapter
    private lateinit var recycleView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_solo, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val grid = GridLayoutManager(context, 2)
        recycleView = view.findViewById(R.id.list_hewan_view)
        recycleView.layoutManager = grid
//        recycleView.hasFixedSize(true)
        adapter = SoloAdapter(AlbumGrup)
        recycleView.adapter = adapter
    }


}