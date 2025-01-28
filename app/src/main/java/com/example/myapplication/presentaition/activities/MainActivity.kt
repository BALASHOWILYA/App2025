package com.example.myapplication.presentaition.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.repositories.UserRepositoryImpl
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.domain.usecases.GetUsersUseCase
import com.example.myapplication.presentaition.viewmodels.UserViewModel
import com.example.myapplication.presentaition.viewmodelfactories.UserViewModelFactory
import kotlinx.coroutines.launch

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userRepository = UserRepositoryImpl()
        val getUsersUseCase = GetUsersUseCase(userRepository)
        val viewModelFactory = UserViewModelFactory(getUsersUseCase)

        userViewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]
        activityMainBinding.buttonId.setOnClickListener{
            lifecycleScope.launch {

                userViewModel.users.collect() { users ->
                    activityMainBinding.nameId.text = users.joinToString("/n"){ it.name }
                }
                userViewModel.fetchUsers()
            }
        }
    }
}
