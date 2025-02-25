package com.example.myapplication.presentaition.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.repositories.getUsersRepositoryImpl
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.AddUserUseCase
import com.example.myapplication.domain.usecases.GetUsersUseCase
import com.example.myapplication.presentaition.ui.fragments.RegistrationFragment
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

        val userRepository = getUsersRepositoryImpl()
        val addUserUseCase = AddUserUseCase(userRepository)
        val getUsersUseCase = GetUsersUseCase(userRepository)
        val viewModelFactory = UserViewModelFactory(getUsersUseCase)
        val addUserViewModelFactory = AddUserViewModelFactory(addUserUseCase)




        userViewModel = ViewModelProvider(this, viewModelFactory)[UserViewModel::class.java]
        addUserViewModel = ViewModelProvider(this, addUserViewModelFactory)[AddUserViewModel::class.java]
        /*
        binding.buttonId.setOnClickListener{
            val name = binding.editNameId.text.toString()
            val surname = binding.editSurnameId.text.toString()
            val age = binding.editAgeId.text.toString()

            if(name.isNotEmpty() && surname.isNotEmpty() && age.isNotEmpty()){

                addUserViewModel.addUser(User(name = name, surname = surname, age= age.toInt()))
            }
            lifecycleScope.launchWhenResumed {

                userViewModel.users.collect() { users ->
                    displayUsers(users)
                }
            }
        }
        */

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


    private fun displayUsers(users: List<User>){
        /*
        val sb = StringBuilder()
        users.forEach{
            user ->
            sb.append("${user.name}\n")
            Log.d("SecondTag",  user.toString())
        }
        binding.surnameId.text = sb.toString()
        */
    }
}
