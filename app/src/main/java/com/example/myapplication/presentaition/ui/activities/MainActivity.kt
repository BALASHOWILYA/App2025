package com.example.myapplication.presentaition.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.data.repositories.getUsersRepositoryImpl
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.GetUsersUseCase
import com.example.myapplication.presentaition.ui.fragments.UserProfileFragment
import com.example.myapplication.presentaition.viewmodelfactories.UserViewModelFactory
import com.example.myapplication.presentaition.viewmodels.UserViewModel

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userProfileFragment = UserProfileFragment()

        val userRepository = getUsersRepositoryImpl()
        val getUsersUseCase = GetUsersUseCase(userRepository)
        val viewModelFactory = UserViewModelFactory(getUsersUseCase)

        userViewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]
        binding.buttonId.setOnClickListener{
            lifecycleScope.launchWhenResumed {

                userViewModel.users.collect() { users ->
                    displayUsers(users)
                }
            }
        }
    }

    private fun addFragment(fragment: Fragment, containerId: Int) {
        if (supportFragmentManager.findFragmentById(containerId) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(containerId, fragment)
                .commitAllowingStateLoss()
        }
    }

    private fun replaceFragment(fragment: Fragment, containerId: Int) {
        if (supportFragmentManager.findFragmentById(containerId) == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(containerId, fragment)
                .commitAllowingStateLoss()
        }
    }

    private fun removeFragment(fragment: Fragment, containerId: Int) {
        if (supportFragmentManager.findFragmentById(containerId) == null) {
            supportFragmentManager
                .beginTransaction()
                .remove(fragment)
                .commitAllowingStateLoss()
        }
    }

    private fun displayUsers(users: List<User>){
        val sb = StringBuilder()
        users.forEach{
            user ->
            sb.append("${user.name}\n")
            Log.d("SecondTag",  user.toString())
        }
        binding.surnameId.text = sb.toString()
    }
}
