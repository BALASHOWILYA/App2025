package com.example.myapplication.presentaition.ui.fragments.courses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.application.MyApplication
import com.example.myapplication.databinding.FragmentCoursesBinding
import com.example.myapplication.domain.usecases.courseusecase.GetCoursesUseCase
import com.example.myapplication.presentaition.ui.adapters.ItemCourseAdapter
import com.example.myapplication.presentaition.viewmodelfactories.coursefactory.GetCourseViewModelFactory
import com.example.myapplication.presentaition.viewmodels.courseviewmodel.GetCourseViewModel
import kotlinx.coroutines.launch


class CoursesFragment : Fragment() {

    private var _binding: FragmentCoursesBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemCourseAdapter
    private lateinit var getCourseViewModel: GetCourseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoursesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val app = requireActivity().applicationContext as MyApplication
        val getCoursesRepository = app.getCoursesRepositoryImpl

        val getCourseUseCase =
            com.example.myapplication.domain.usecases.courseusecase.GetCoursesUseCase(
                getCoursesRepository
            )
        val getCoursesViewModelFactory = GetCourseViewModelFactory(getCourseUseCase)


        getCourseViewModel = ViewModelProvider(this, getCoursesViewModelFactory)[GetCourseViewModel::class.java]


        val manager = LinearLayoutManager(requireContext()) // LayoutManager
        adapter = ItemCourseAdapter(requireActivity())
        observeViewModel()

        binding.apply {
            courseRecyclerView.layoutManager = manager
            courseRecyclerView.adapter = adapter
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

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                getCourseViewModel.courses.collect { items ->
                    adapter.updateList(items) // Обновляем данные адаптера
                }
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CoursesFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}