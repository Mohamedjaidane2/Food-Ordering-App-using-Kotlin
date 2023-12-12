package com.example.foodordring.CatFragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordring.R
import com.example.foodordring.ui.home.Food
import com.example.foodordring.ui.home.FoodAdapter
import com.example.foodordring.ui.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_food.*


class FoodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_fast_food, container, false)
        return  view
    }

}