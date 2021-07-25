package com.selen.english.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.selen.english.R

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.main_activity_bottom_navigation)

        navController = Navigation.findNavController(this, R.id.main_activity_fragment_container)
        bottomNavigationView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.main_activity_fragment_container).navigateUp()
}