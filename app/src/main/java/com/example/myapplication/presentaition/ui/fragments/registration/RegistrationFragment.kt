package com.example.myapplication.presentaition.ui.fragments.registration


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.application.MyApplication
import com.example.myapplication.databinding.FragmentRegistrationBinding
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.userusecase.AddUserUseCase
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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val app = requireActivity().applicationContext as MyApplication
        val addUserRepository = app.IAddUserRepositoryImpl

        val addUserUseCase = AddUserUseCase(addUserRepository)
        val addUserViewModelFactory = AddUserViewModelFactory(addUserUseCase)

        addUserViewModel = ViewModelProvider(this, addUserViewModelFactory)[AddUserViewModel::class.java]



        binding.profileBtnId.setOnClickListener {

            Log.d("ButtenTag", "pressed")
            val name = binding.editUsernameId.text.toString()
            val password = binding.editPasswordId.text.toString()
            val phoneNumber = binding.editPhoneNumberId.toString()
            val age = binding.editAgeId.text.toString()

            if(name.isNotEmpty() && password.isNotEmpty() && age.isNotEmpty() && phoneNumber.isNotEmpty()){
                savedInstanceState?.putString(ARG_PROFILE_NAME, name)
                savedInstanceState?.putString(ARG_PHONE_NUMBER, phoneNumber)
                savedInstanceState?.putString(ARG_AGE, age)
                addUserViewModel.addUser(User(username = name, password = password, phoneNumber = phoneNumber, age = age.toInt()))
                replaceFragment(MUserProfileFragment::class.java.name) // Используем .name для получения полного имени класса
            }

        }

    }


    companion object {

        const val ARG_PROFILE_NAME = "arg_username"
        const val ARG_PHONE_NUMBER = "arg_phonenumber"
        const val ARG_AGE = "arg_age"

        @JvmStatic
        fun newInstance(profileName: String, phone: String, age: Int) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(MUserProfileFragment.ARG_PROFILE_NAME,profileName)
                    putString(MUserProfileFragment.ARG_PHONE_NUMBER,phone)
                    putInt(MUserProfileFragment.ARG_AGE,age)
                }
            }
    }
}