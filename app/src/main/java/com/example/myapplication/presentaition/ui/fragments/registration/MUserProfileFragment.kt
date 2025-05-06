package com.example.myapplication.presentaition.ui.fragments.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUserProfileBinding
import com.example.myapplication.presentaition.ui.fragments.courses.AddCourseFragment
import com.example.myapplication.presentaition.ui.fragments.courses.CoursesFragment
import com.example.myapplication.presentaition.viewmodels.userviewmodel.GetUserViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ARG_PASSWORD_PARAM1 = "ARG_PASSWORD_STRING"
private const val ARG_USERNAME_PARAM2 ="ARG_USERNAME_STRING"
private const val ARG_PHONE_NUMBER_PARAM3 = "ARG_PHONE_NUMBER_STRING"
private const val ARG_AGE_PARAM4 = "ARG_AGE_STRING"
private const val ARG_PROFILE_PHOTO_PARAM5 = "ARG_PROFILE_PHOTO"

class MUserProfileFragment : Fragment() {


    private val getUserViewModel: GetUserViewModel by viewModel<GetUserViewModel>()

    private var param1Password: String? = null
    private var param2Username: String? = null
    private var param3PhoneNumber: String? = null
    private var param4Age: Int? = null
    private var param5Photo: Int? = null
    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Восстанавливаем данные из сохраненного состояния или аргументов
        if (savedInstanceState != null) {
            param1Password = savedInstanceState.getString(ARG_PASSWORD_PARAM1)
            param2Username = savedInstanceState.getString(ARG_USERNAME_PARAM2)
            param3PhoneNumber = savedInstanceState.getString(ARG_PHONE_NUMBER_PARAM3)

            param4Age = if (savedInstanceState.containsKey(ARG_AGE_PARAM4)) {
                savedInstanceState.getInt(ARG_AGE_PARAM4)
            } else {
                null
            }
            param5Photo = if(savedInstanceState.containsKey(ARG_PROFILE_PHOTO_PARAM5)){
                savedInstanceState.getInt(ARG_PROFILE_PHOTO_PARAM5)
            }else{
                null
            }
        } else {
            arguments?.let {
                param1Password = it.getString(ARG_PASSWORD_PARAM1)
                param2Username = it.getString(ARG_USERNAME_PARAM2)
                param3PhoneNumber = it.getString(ARG_PHONE_NUMBER_PARAM3)
                param4Age = if (it.containsKey(ARG_AGE_PARAM4)) it.getInt(ARG_AGE_PARAM4) else null
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
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

        // Если аргументы не были переданы — подгружаем из ViewModel
        if (param5Photo == null || param2Username == null || param3PhoneNumber == null || param4Age == null) {
            viewLifecycleOwner.lifecycleScope.launch {
                getUserViewModel.user.collectLatest { user ->
                    user?.let {
                        param1Password = it.password
                        param2Username = it.username
                        param3PhoneNumber = it.phoneNumber
                        param5Photo = it.profilePhoto
                        param4Age = it.age

                        // Обновляем UI
                        binding.profileAgeId.text = param4Age.toString()
                        binding.profileNameId.text = param2Username
                        binding.profileCurrentPhoneId.text = param3PhoneNumber

                        Glide.with(requireContext())
                            .load(param5Photo)
                            .placeholder(R.drawable.course)
                            .into(binding.profileImageId)
                    }
                }
            }
        } else {
            // Используем данные из аргументов
            binding.profileAgeId.text = param4Age.toString()
            binding.profileNameId.text = param2Username
            binding.profileCurrentPhoneId.text = param3PhoneNumber

            Glide.with(requireContext())
                .load(param5Photo)
                .placeholder(R.drawable.course)
                .into(binding.profileImageId)
        }

        binding.profileButtonForCoursesId.setOnClickListener {
            replaceFragment(CoursesFragment::class.java.name)
        }

        binding.profileButtonForAddingCoursesId.setOnClickListener {
            replaceFragment(AddCourseFragment::class.java.name)
        }
    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.apply {
            putString(ARG_PASSWORD_PARAM1, param1Password)
            putString(ARG_USERNAME_PARAM2, param2Username)
            putString(ARG_PHONE_NUMBER_PARAM3, param3PhoneNumber)
            param4Age?.let { putInt(ARG_AGE_PARAM4, it) }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(
        ) = MUserProfileFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PASSWORD_PARAM1, param1Password)
                putString(ARG_USERNAME_PARAM2, param2Username)
                putString(ARG_PHONE_NUMBER_PARAM3, param3PhoneNumber)
                param4Age?.let { putInt(ARG_AGE_PARAM4, it) }
            }
        }
    }


}