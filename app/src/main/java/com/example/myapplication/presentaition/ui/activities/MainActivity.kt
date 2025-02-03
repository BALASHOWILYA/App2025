package com.example.myapplication.presentaition.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.data.repositories.getUsersRepositoryImpl
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.GetUsersUseCase
import com.example.myapplication.presentaition.viewmodels.UserViewModel
import com.example.myapplication.presentaition.viewmodelfactories.UserViewModelFactory

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
