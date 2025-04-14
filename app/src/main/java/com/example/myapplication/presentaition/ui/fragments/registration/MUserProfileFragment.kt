package com.example.myapplication.presentaition.ui.fragments.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUserProfileBinding
import com.example.myapplication.presentaition.constants.ARG_AGE
import com.example.myapplication.presentaition.constants.ARG_PHONE_NUMBER
import com.example.myapplication.presentaition.constants.ARG_PROFILE_NAME
import com.example.myapplication.presentaition.ui.fragments.courses.AddCourseFragment
import com.example.myapplication.presentaition.ui.fragments.courses.CoursesFragment

private const val ARG_PARAM1 = "ARG_AGE_STRING"
private const val ARG_PARAM2 ="ARG_USERNAME_STRING"
private const val ARG_PARAM3 = "ARG_PHONE_NUMBER_STRING"



class MUserProfileFragment : Fragment() {



    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
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
            profileAgeId.text = param1.toString()
            profileNameId.text = param2
            profileCurrentPhoneId.text = param3

            profileButtonForCoursesId.setOnClickListener{
                replaceFragment(CoursesFragment::class.java.name)
            }

            profileButtonForAddingCoursesId.setOnClickListener{
                replaceFragment(AddCourseFragment::class.java.name)
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