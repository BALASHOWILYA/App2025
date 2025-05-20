package com.example.myapplication.presentaition.ui.fragments.courses

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.presentaition.application.MyApplication
import com.example.myapplication.databinding.FragmentAddCourseBinding
import com.example.myapplication.databinding.FragmentCoursesBinding
import com.example.myapplication.domain.models.Course
import com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment
import com.example.myapplication.presentaition.ui.screens.AddCourseScreen
import com.example.myapplication.presentaition.ui.screens.LoginScreen
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.AddCourseViewModel
import com.example.myapplication.presentaition.viewmodels.userviewmodel.AddUserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddCourseFragment : Fragment() {

    private lateinit var composeView: ComposeView
    private val addCourseViewModel: AddCourseViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).also {

            composeView = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        composeView.setContent {
            AddCourseScreen (
                addCourseViewModel = addCourseViewModel,
                onNextClick = {
                    replaceFragment(MUserProfileFragment::class.java.name)
                }
            )
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

    @Preview
    @Composable
    fun AddCourseScreenPreview(){
        AddCourseScreen (
            addCourseViewModel = addCourseViewModel,
            onNextClick = {}
        )
    }
}