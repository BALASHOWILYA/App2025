package com.example.myapplication.presentaition.ui.fragments.courses

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.presentaition.application.MyApplication
import com.example.myapplication.databinding.FragmentAddCourseBinding
import com.example.myapplication.databinding.FragmentCoursesBinding
import com.example.myapplication.domain.models.Course
import com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.AddCourseViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.AddUserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddCourseFragment : Fragment() {

    private var _binding: FragmentAddCourseBinding? = null
    private val binding get() = _binding!!
    private val addCourseViewModel: AddCourseViewModel by viewModel<AddCourseViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddCourseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.addCourseButtonId.setOnClickListener {

            val name = binding.editNameCourseId.text.toString()
            val intro = binding.editIntroCourseId.text.toString()
            val description = binding.editDescriptionCourseId.text.toString()


            if(name.isNotEmpty() && intro.isNotEmpty() && description.isNotEmpty()){

                addCourseViewModel.addCourse(Course(
                        coursePicture = R.drawable.course,
                        name = name,
                        intro = intro,
                        description = description
                    )
                )
                replaceFragment(MUserProfileFragment::class.java.name) // Используем .name для получения полного имени класса
            }

        }
    }

    private fun replaceFragment(fragmentName: String) {

        if (fragmentName.isEmpty()) {
            throw IllegalArgumentException("Fragment name cannot be empty")
        }

        try {

            val fragment = requireActivity().supportFragmentManager.fragmentFactory.instantiate(requireActivity().classLoader, fragmentName)

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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddCourseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            AddCourseFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}