package com.example.myapplication.presentaition.ui.fragments.registration


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startForegroundService
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


import com.example.myapplication.R
import com.example.myapplication.presentaition.application.MyApplication
import com.example.myapplication.databinding.FragmentRegistrationBinding
import com.example.myapplication.domain.models.Course
import com.example.myapplication.domain.models.User
import com.example.myapplication.presentaition.viewmodels.userviewmodel.AddUserViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.UserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private var text: String? = null
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by viewModel<UserViewModel>()
    private val addUserViewModel: AddUserViewModel by viewModel<AddUserViewModel>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }


    private fun replaceFragment(fragmentName: String, user: User) {
        // Проверка, что fragmentName не пустой
        if (fragmentName.isEmpty()) {
            throw IllegalArgumentException("Fragment name cannot be empty")
        }

        try {
            // Создание фрагмента
            val fragment = requireActivity().supportFragmentManager.fragmentFactory
                .instantiate(requireActivity().classLoader, fragmentName)

            // Set arguments using a Bundle
            fragment.arguments = Bundle().apply {
                // Add data to the bundle
                putString("ARG_USERNAME_STRING", user.username)
                putString("ARG_PHONE_NUMBER_STRING", user.phoneNumber)
                putString("ARG_AGE_STRING", user.age.toString())
                putInt("ARG_PROFILE_PHOTO", com.example.myapplication.R.drawable.course)
                // Add other data types as needed
            }

            // Замена фрагмента
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container_id, fragment)
                .addToBackStack(null) // Добавление транзакции в back stack
                .commitAllowingStateLoss() // Подтверждение транзакции
        } catch (e: Fragment.InstantiationException) {
            // Обработка ошибки
            e.printStackTrace()
            throw RuntimeException("Failed to instantiate fragment: $fragmentName", e)
        }
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.profileBtnId.setOnClickListener {

            Log.d("ButtenTag", "pressed")
            val name = binding.editUsernameId.text.toString()
            val password = binding.editPasswordId.text.toString()
            val phoneNumber = binding.editPhoneNumberId.text.toString()
            val age = binding.editAgeId.text.toString()

            Log.d("ButtenTag", age)
            if(name.isNotEmpty() && password.isNotEmpty() && age.isNotEmpty() && phoneNumber.isNotEmpty()){
                // Создаем Bundle и передаем аргументы

                val user: User = User( username = name,
                    password = password,
                    phoneNumber = phoneNumber,
                    age = age.toInt())
                Log.d("ButtenTag", user.toString())


                addUserViewModel.addUser(user)
                replaceFragment(MUserProfileFragment::class.java.name, user) // Используем .name для получения полного имени класса
                // Проверка разрешений перед запуском сервиса

            }

        }

    }










    companion object {


        @JvmStatic
        fun newInstance() =
            RegistrationFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}