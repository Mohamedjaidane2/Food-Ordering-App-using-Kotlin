package com.example.foodordring.Fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(FragmentManager:FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(FragmentManager,lifecycle) {

    override fun getItemCount(): Int {
        return 2;

    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0->{

                SignupFragment()
            }
            1->{
                LoginFragment()
            }
            else->{
                Fragment()
            }
        }
    }
}