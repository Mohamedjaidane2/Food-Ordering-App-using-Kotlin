package com.example.foodordring.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordring.CatFragments.CatPagerAdapter
import com.example.foodordring.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.login_layout.*


class HomeActivity : AppCompatActivity() , FoodAdapter.OnItemClickListener{
    private lateinit var recyclerViewFoods: RecyclerView
    private lateinit var foodAdapter:FoodAdapter
    val items= listOf(
        Food("Fried chicken m.",2 ,R.drawable.plat2,"84.99 Dt","Foods","24865022"),
        Food("Veggie tomato mix",5 ,R.drawable.plat_1,"99.00 Dt","Foods","24865022") ,
        Food("Fried chicken m.",2 ,R.drawable.plat2,"84.99 Dt","Foods","24865022"),
        Food("Moi-moi and epa.",3 ,R.drawable.plat4,"74.99 Dt","Snacks","24865022"),
        Food("Egg and cucumber...",1 ,R.drawable.plat3,"90.00 Dt","Snacks","24865022"),
        Food("Moi-moi and epa.",3 ,R.drawable.plat4,"74.99 Dt","Snacks","24865022"),
        Food("Veggie tomato mix",5 ,R.drawable.plat_1,"99.00 Dt","Foods","24865022") ,
    )

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        Delicious.text = "Delicious"+ "\nfood for you"


        foodAdapter=FoodAdapter(items,this)

        recyclerViewFoods=recyclerViewFood
        val horizontalLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewFoods.layoutManager = horizontalLayoutManager

        recyclerViewFoods.adapter=foodAdapter
        val adapter=CatPagerAdapter(supportFragmentManager, lifecycle)
        cat_viewpager.adapter = adapter
        TabLayoutMediator(tabLayout_cat, cat_viewpager) { tab, position ->

            when (position) {
                0 -> {

                    tab.text = "Foods"
                }
                1 -> {
                    tab.text = "Snacks"
                }
                2 -> {
                    tab.text = "Fast Foods"

                }

            }

        }.attach()

        search_icon.setOnClickListener{
            val search=search_bar.text.toString()
            foodAdapter.filter.filter(search)
        }



    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this,"Item $position clicked",Toast.LENGTH_SHORT).show()
    val clickedItem=items[position]
        val intent=Intent(this,FoodDetails::class.java)
        intent.putExtra("title",clickedItem.title)
        intent.putExtra("rating",clickedItem.rating)
        intent.putExtra("price",clickedItem.price)
        intent.putExtra("img",clickedItem.img)
        intent.putExtra("tel",clickedItem.tel)
        startActivity(intent)

        foodAdapter.notifyItemChanged(position)
    }

}