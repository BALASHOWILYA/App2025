package com.example.myapplication.presentaition.ui.fragments.fragmentfactory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.myapplication.presentaition.ui.fragments.courses.AddCourseFragment
import com.example.myapplication.presentaition.ui.fragments.courses.CourseFragment
import com.example.myapplication.presentaition.ui.fragments.registration.RegistrationFragment
import com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment
import com.example.myapplication.presentaition.ui.fragments.courses.CoursesFragment

class MFragmentFactory(): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className){
            RegistrationFragment::class.java.toString() -> RegistrationFragment.newInstance()
            MUserProfileFragment::class.java.toString() -> MUserProfileFragment.newInstance()
            CoursesFragment::class.java.toString() -> CoursesFragment.newInstance()
            AddCourseFragment::class.java.toString() -> AddCourseFragment.newInstance()
            CourseFragment::class.java.toString() -> CourseFragment.newInstance()
            else -> super.instantiate(classLoader, className)
        }
    }
}