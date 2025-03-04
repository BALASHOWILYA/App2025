package com.example.myapplication.presentaition.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.application.MyApplication
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.AddUserUseCase
import com.example.myapplication.domain.usecases.GetUsersUseCase
import com.example.myapplication.presentaition.ui.fragments.common.RegistrationFragment
import com.example.myapplication.presentaition.ui.fragments.fragmentfactory.MFragmentFactory
import com.example.myapplication.presentaition.viewmodelfactories.AddUserViewModelFactory
import com.example.myapplication.presentaition.viewmodelfactories.UserViewModelFactory
import com.example.myapplication.presentaition.viewmodels.AddUserViewModel
import com.example.myapplication.presentaition.viewmodels.UserViewModel

@Suppress("UNREACHABLE_CODE", "DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel
    private lateinit var addUserViewModel: AddUserViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MFragmentFactory("first fragment", 1)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            replaceFragment(RegistrationFragment::class.java.toString())
        }

        // Get the Application context properly
        val app = applicationContext as MyApplication
        val getUserRepository = app.getUsersRepositoryImpl
        val addUserRepository = app.addUserRepositoryImpl
        val addUserUseCase = AddUserUseCase(addUserRepository)
        val getUsersUseCase = GetUsersUseCase(getUserRepository)
        val viewModelFactory = UserViewModelFactory(getUsersUseCase)


    }

    private fun addFragment(fragmentName: String,) {
        val fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, fragmentName)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_id, fragment)
            .commitAllowingStateLoss()
    }

    fun replaceFragment(fragmentName: String,) {
        val fragment = supportFragmentManager.fragmentFactory.instantiate(classLoader, fragmentName)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_id, fragment)
            .commitAllowingStateLoss()
    }



}
