package com.example.myapplication.presentaition.ui.fragments.courses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCourseBinding



private const val ARG_PARAM1 = "ARG_NAME_STRING"
private const val ARG_PARAM2 = "ARG_INTRO_STRING"
private const val ARG_PARAM3 = "ARG_DESCRIPTION_STRING"

class CourseFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var _binding: FragmentCourseBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            courseNameId.text = param1
            courseIntroId.text = param2
            courseDescriptionId.text = param3

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        return binding.root
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            CourseFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}