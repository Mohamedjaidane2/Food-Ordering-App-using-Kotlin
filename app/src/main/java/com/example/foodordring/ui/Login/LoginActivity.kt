package com.example.foodordring.ui.Login

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.annotation.RequiresApi
import com.example.foodordring.Fragments.ViewPagerAdapter
import com.example.foodordring.R
import com.example.foodordring.ui.home.HomeActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.login_layout.*


class LoginActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.login_layout)

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        auth_viewpager.adapter = adapter
        TabLayoutMediator(tabLayout, auth_viewpager) { tab, position ->

            when (position) {
                0 -> {

                    tab.text = "SignUp"
                }
                1 -> {
                    tab.text = "Login"
                }
            }

        }.attach()





        }
    }