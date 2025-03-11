package com.example.myapplication.presentaition.ui.fragments.fragmentfactory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.myapplication.presentaition.ui.fragments.registration.RegistrationFragment
import com.example.myapplication.presentaition.ui.fragments.registration.MUserProfileFragment

class MFragmentFactory(private val userProfile: String, private val email: String, private val age: Int): FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className){
            RegistrationFragment::class.java.toString() -> RegistrationFragment.newInstance(userProfile,email,age )
            MUserProfileFragment::class.java.toString() -> MUserProfileFragment.newInstance()
            else -> super.instantiate(classLoader, className)
        }
    }
}