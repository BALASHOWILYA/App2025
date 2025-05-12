package com.example.myapplication.presentaition.ui.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope

import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.presentaition.ui.fragments.registration.RegistrationFragment
import com.example.myapplication.presentaition.ui.fragments.fragmentfactory.MFragmentFactory
import com.example.myapplication.presentaition.ui.fragments.registration.LogINFragment
import com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment
import com.example.myapplication.presentaition.ui.fragments.settings.FragmentSettings
import com.example.myapplication.presentaition.viewmodels.userviewmodel.GetUserViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private val getUserViewModel: GetUserViewModel by viewModel<GetUserViewModel>()
    var menuResId: Int = com.example.myapplication.R.menu.menu

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MFragmentFactory()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        try {
            lifecycleScope.launch {
                getUserViewModel.user.collectLatest { user ->
                    if (user != null) {
                        replaceFragment(MUserProfileFragment::class.java.toString())
                    } else {
                        replaceFragment(RegistrationFragment::class.java.toString())
                    }
                }
            }
        }
        catch (e: Exception){
          Log.d("DBException", e.toString())
        }
        setup_menu()

    }

    private fun setup_menu() {

        val menuHost: MenuHost = this


        menuHost.addMenuProvider(object: MenuProvider{


            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(menuResId, menu)
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
                    R.id.nav_login_id ->{
                        replaceFragment(LogINFragment::class.java.toString())
                        true
                    }
                    com.example.myapplication.R.id.nav_logout_id->{
                        menuResId = com.example.myapplication.R.menu.second_menu
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
