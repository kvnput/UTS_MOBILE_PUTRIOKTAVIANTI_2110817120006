package com.putrioktavianti.Album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.putrioktavianti.Album.databinding.ActivityMainBinding
import com.putrioktavianti.Album.fragment.SoloFragment
import com.putrioktavianti.Album.fragment.GrupFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    val fragmentSolo: Fragment = SoloFragment()
    val fragmentGrup: Fragment = GrupFragment()
    val fm: FragmentManager = supportFragmentManager
    var active : Fragment = fragmentSolo

    private lateinit var bottomNavigationId: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonNavigation()
    }

    private fun buttonNavigation() {
        fm.beginTransaction().add(R.id.container, fragmentSolo).show(fragmentSolo).commit()
        fm.beginTransaction().add(R.id.container, fragmentGrup).hide(fragmentGrup).commit()

        bottomNavigationId = binding.navView
        menu = bottomNavigationId.menu

        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationId.setOnNavigationItemSelectedListener {item ->
            when(item.itemId) {
                R.id.navigation_solo -> {
                    callFragment(0, fragmentSolo)
                }

                R.id.navigation_grup -> {
                    callFragment(1, fragmentGrup)
                }
            }
            false
        }
    }

    private fun callFragment(index: Int, fragment: Fragment) {
        menuItem  = menu.getItem(index)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}