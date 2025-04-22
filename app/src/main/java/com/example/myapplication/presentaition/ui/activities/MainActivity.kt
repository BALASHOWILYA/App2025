package com.example.myapplication.presentaition.ui.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentaition.ui.fragments.registration.RegistrationFragment
import com.example.myapplication.presentaition.ui.fragments.fragmentfactory.MFragmentFactory
import com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment
import com.google.android.material.navigation.NavigationView

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MFragmentFactory()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            replaceFragment(MUserProfileFragment::class.java.toString())
        }

    }



    private fun replaceFragment(fragmentName: String,) {
        val fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, fragmentName)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_id, fragment)
            .commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        super.onBackPressed()


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        val itemId: Int = item.itemId;
        if(itemId == com.example.myapplication.R.id.nav_profile_id){
            replaceFragment(MUserProfileFragment::class.java.toString())
        }

        if(itemId == com.example.myapplication.R.id.nav_first_game_id){
            replaceFragment(MUserProfileFragment::class.java.toString())
        }

        if(itemId == com.example.myapplication.R.id.nav_logout_id) {
            replaceFragment(MUserProfileFragment::class.java.toString())
        }
        return true
    }


}
