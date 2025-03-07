package com.example.myapplication.presentaition.ui.fragments.common


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.R
import com.example.myapplication.data.application.MyApplication
import com.example.myapplication.databinding.FragmentRegistrationBinding
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.AddUserUseCase
import com.example.myapplication.domain.usecases.GetUsersUseCase
import com.example.myapplication.presentaition.viewmodelfactories.AddUserViewModelFactory
import com.example.myapplication.presentaition.viewmodelfactories.UserViewModelFactory
import com.example.myapplication.presentaition.viewmodels.AddUserViewModel
import com.example.myapplication.presentaition.viewmodels.UserViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("DEPRECATION")
class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var userViewModel: UserViewModel
    private lateinit var addUserViewModel: AddUserViewModel
    private var text: String? = null
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            text = it.getString(ARG_TEXT)

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


        binding.profileBtnId.setOnClickListener {
            Log.d("ButtenTag", "pressed")
            replaceFragment(MUserProfileFragment::class.java.name) // Используем .name для получения полного имени класса
        }


        // Get the Application context properly
        val app = requireActivity().applicationContext as MyApplication
        val getUserRepository = app.getUsersRepositoryImpl
        val addUserRepository = app.addUserRepositoryImpl
        val addUserUseCase = AddUserUseCase(addUserRepository)
        val getUsersUseCase = GetUsersUseCase(getUserRepository)
        val viewModelFactory = UserViewModelFactory(getUsersUseCase)
        val addUserViewModelFactory = AddUserViewModelFactory(addUserUseCase)
        userViewModel = ViewModelProvider(requireActivity(), viewModelFactory)[UserViewModel::class.java]
        addUserViewModel = ViewModelProvider(requireActivity(), addUserViewModelFactory)[AddUserViewModel::class.java]

        binding.profileBtnId.setOnClickListener{
            val name = binding.editUsernameId.text.toString()
            val password = binding.editPasswordId.text.toString()
            val age = binding.editAgeId.text.toString()
            val phoneNumber = binding.editPhoneNumberId.text.toString()

            if(name.isNotEmpty() && password.isNotEmpty() && age.isNotEmpty() && phoneNumber.isNotEmpty() ){

                addUserViewModel.addUser(User(username = name, password = password, age= age.toInt(), phoneNumber=phoneNumber.toInt()))
            }

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
            sb.append("${user.username}\n")
            Log.d("SecondTag",  user.toString())
        }
        binding.usernamesId.text = sb.toString()
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private const val ARG_TEXT = "text"
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(text: String) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_TEXT,text)

                }
            }
    }
}