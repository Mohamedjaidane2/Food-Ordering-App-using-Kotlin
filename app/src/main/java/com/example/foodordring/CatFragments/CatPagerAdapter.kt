package com.example.foodordring.CatFragments
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.foodordring.Fragments.LoginFragment
import com.example.foodordring.Fragments.SignupFragment
import com.example.foodordring.ui.home.FoodAdapter
import com.example.foodordring.ui.home.HomeActivity

class CatPagerAdapter (FragmentManager:FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(FragmentManager,lifecycle){

    override fun getItemCount(): Int {
        return 3;

    }
    override fun createFragment(position: Int): Fragment {
        val currentFragment=0
        return when (position){
            0->{

                FoodFragment()

            }
            1->{
                SnaksFragment()

            }
            2->{
                FastFoodFragment()

            }
            else->{
                Fragment()
            }
        }
    }
}