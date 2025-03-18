package com.example.myapplication.presentaition.ui.fragments.registration

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUserProfileBinding
import com.example.myapplication.presentaition.constants.ARG_AGE
import com.example.myapplication.presentaition.constants.ARG_PHONE_NUMBER
import com.example.myapplication.presentaition.constants.ARG_PROFILE_NAME
import com.example.myapplication.presentaition.ui.fragments.registration.RegistrationFragment.Companion
import com.example.myapplication.presentaition.ui.fragments.showcourses.CoursesFragment


class MUserProfileFragment : Fragment() {



    private var age: Int? = null
    private var username: String? = null
    private var phone: String? = null
    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            age = it.getInt(savedInstanceState?.getString(ARG_AGE)) ?: 0
            username = it.getString(savedInstanceState?.getString(ARG_PROFILE_NAME)) ?: ""
            phone = it.getString(savedInstanceState?.getString(ARG_PHONE_NUMBER)) ?: ""
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


        binding.apply {
            profileAgeId.text = age.toString()
            profileEmailId.text = phone
            profileNameId.text = username

            profileButtonForCoursesId.setOnClickListener{
                replaceFragment(CoursesFragment::class.java.name)
            }

        }







    }
    companion object {



        @JvmStatic
        fun newInstance() =
            RegistrationFragment().apply {

            }
    }


}