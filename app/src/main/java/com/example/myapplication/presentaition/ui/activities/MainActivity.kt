package com.example.myapplication.presentaition.ui.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle

import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentaition.ui.fragments.registration.RegistrationFragment
import com.example.myapplication.presentaition.ui.fragments.fragmentfactory.MFragmentFactory
import com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment
import com.example.myapplication.presentaition.ui.fragments.settings.FragmentSettings
import com.google.android.material.navigation.NavigationView

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MFragmentFactory()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        if(savedInstanceState == null){
            replaceFragment(RegistrationFragment::class.java.toString())
        }

        setup_menu()

    }

    private fun setup_menu() {

        val menuHost: MenuHost = this

        menuHost.addMenuProvider(object: MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(com.example.myapplication.R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when(menuItem.itemId){
                    com.example.myapplication.R.id.nav_profile_id ->{
                        replaceFragment(MUserProfileFragment::class.java.toString())
                        true
                    }
                    com.example.myapplication.R.id.nav_settings_id->{
                        replaceFragment(FragmentSettings::class.java.toString())
                        true
                    }
                    com.example.myapplication.R.id.nav_logout_id->{
                        finish()
                        true
                    }
                    else -> false
                }
            }
        }, this, Lifecycle.State.RESUMED)

    }


    private fun replaceFragment(fragmentName: String,) {
        val fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, fragmentName)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_id, fragment)
            .commitAllowingStateLoss()
    }






}
