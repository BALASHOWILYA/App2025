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
import com.example.myapplication.data.application.MyApplication
import com.example.myapplication.presentaition.services.NotificationService
import com.example.myapplication.databinding.FragmentRegistrationBinding
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.userusecase.AddUserUseCase
import com.example.myapplication.presentaition.constants.ARG_AGE
import com.example.myapplication.presentaition.constants.ARG_PHONE_NUMBER
import com.example.myapplication.presentaition.constants.ARG_PROFILE_NAME
import com.example.myapplication.presentaition.viewmodelfactories.userfactory.AddUserViewModelFactory
import com.example.myapplication.presentaition.viewmodels.userviewmodel.AddUserViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.UserViewModel


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
    private lateinit var userViewModel: UserViewModel
    private lateinit var addUserViewModel: AddUserViewModel

    // Обработчик результата запроса разрешения
    @RequiresApi(Build.VERSION_CODES.O)
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            startNotificationService()
        } else {
            // Обработка отказа в разрешении
            Log.d("Notifications", "Permission denied")
        }
    }


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


    private fun replaceFragment(fragmentName: String) {
        // Проверка, что fragmentName не пустой
        if (fragmentName.isEmpty()) {
            throw IllegalArgumentException("Fragment name cannot be empty")
        }

        try {
            // Создание фрагмента
            val fragment = requireActivity().supportFragmentManager.fragmentFactory
                .instantiate(requireActivity().classLoader, fragmentName)

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


        val app = requireActivity().applicationContext as MyApplication
        val addUserRepository = app.addUserRepositoryImpl

        val addUserUseCase =
            com.example.myapplication.domain.usecases.userusecase.AddUserUseCase(addUserRepository)
        val addUserViewModelFactory = AddUserViewModelFactory(addUserUseCase)

        addUserViewModel = ViewModelProvider(this, addUserViewModelFactory)[AddUserViewModel::class.java]



        binding.profileBtnId.setOnClickListener {

            Log.d("ButtenTag", "pressed")
            val name = binding.editUsernameId.text.toString()
            val password = binding.editPasswordId.text.toString()
            val phoneNumber = binding.editPhoneNumberId.toString()
            val age = binding.editAgeId.text.toString()

            if(name.isNotEmpty() && password.isNotEmpty() && age.isNotEmpty() && phoneNumber.isNotEmpty()){
                // Создаем Bundle и передаем аргументы

                val args = Bundle().apply {
                    putString(ARG_PROFILE_NAME, name)
                    putString(ARG_PHONE_NUMBER, phoneNumber)
                    putString(ARG_AGE, age)
                }

                // Создаем фрагмент с аргументами
                val fragment = MUserProfileFragment().apply {
                    arguments = args
                }
                addUserViewModel.addUser(
                    com.example.myapplication.domain.models.User(
                        username = name,
                        password = password,
                        phoneNumber = phoneNumber,
                        age = age.toInt()
                    )
                )
                replaceFragment(MUserProfileFragment::class.java.name) // Используем .name для получения полного имени класса
                // Проверка разрешений перед запуском сервиса
                checkPermissionAndStartService()
            }

        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun checkPermissionAndStartService() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.FOREGROUND_SERVICE
                ) ==  PackageManager.PERMISSION_GRANTED -> {
                    startNotificationService()
                }
                else -> {
                    requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    requestPermissionLauncher.launch(Manifest.permission.FOREGROUND_SERVICE)
                }
            }
        } else {
            // Для версий ниже Android 13 разрешение не требуется
            startNotificationService()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startNotificationService() {
        val serviceIntent = Intent(requireActivity(), NotificationService::class.java)

        requireActivity().startForegroundService(serviceIntent)
    }



    private fun stopNotificationService(){
        val serviceIntent = Intent(requireActivity(), NotificationService::class.java)
        requireActivity().stopService(serviceIntent)
    }



    companion object {


        @JvmStatic
        fun newInstance(profileName: String, phone: String, age: Int) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PROFILE_NAME,profileName)
                    putString(ARG_PHONE_NUMBER,phone)
                    putInt(ARG_AGE,age)
                }
            }
    }
}