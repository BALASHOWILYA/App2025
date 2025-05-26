package com.example.myapplication.presentaition.ui.fragments.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.viewModels
import com.example.myapplication.R
import com.example.myapplication.presentaition.ui.screens.LoginScreen
import com.example.myapplication.presentaition.viewmodels.userviewmodel.CheckUserViewModel


class LogINFragment : Fragment() {

    private lateinit var composeView: ComposeView
    private val viewModel: CheckUserViewModel by viewModels()

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
            LoginScreen(
                checkUserViewModel = viewModel,
                onNextClick = {
                    replaceFragment(MUserProfileFragment::class.java.name)
                }
            )
        }
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

    companion object {
        @JvmStatic
        fun newInstance() = LogINFragment()
    }

    @Preview
    @Composable
    fun LoginScreenPreview(){
        LoginScreen(
            checkUserViewModel = viewModel,
            onNextClick = {
                replaceFragment(MUserProfileFragment::class.java.name)
            }
        )
    }
}
