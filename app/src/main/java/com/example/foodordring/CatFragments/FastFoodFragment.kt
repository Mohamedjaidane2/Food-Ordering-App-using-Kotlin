package com.example.foodordring.CatFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordring.R
import com.example.foodordring.ui.home.Food
import com.example.foodordring.ui.home.FoodAdapter
import com.example.foodordring.ui.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_fast_food.*
import kotlinx.android.synthetic.main.fragment_food.*

class FastFoodFragment : Fragment() {
    lateinit var recyclerViewFoods: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_fast_food, container, false)

        // Inflate the layout for this fragment
        return view
    }

}