package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.viewmodels.MainActivityViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(Timber.DebugTree())

        // Inflate view and obtain an instance of the binding class
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )

        // Set up toolbar and navigation
        setSupportActionBar(binding.toolbar)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration
            .Builder(R.id.loginFragment)
            .build()
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)

        // Get the viewmodel
        mViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }
}
