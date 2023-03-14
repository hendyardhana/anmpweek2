package com.example.anmpweek2kpc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var drawerlayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerlayout = findViewById(R.id.drawerLayout)

        navController= (supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment).navController

        NavigationUI.setupActionBarWithNavController(this, navController, drawerlayout)

        val navview = findViewById<NavigationView>(R.id.navView)
        NavigationUI.setupWithNavController(navview, navController)

        val bottomnav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomnav.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerlayout) || super.onSupportNavigateUp()
    }
}