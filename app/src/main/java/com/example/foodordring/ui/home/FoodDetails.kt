package com.example.foodordring.ui.home

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.foodordring.R
import kotlinx.android.synthetic.main.activity_food_details.*

class FoodDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_food_details)
        foodimg.setBackgroundResource(intent.getIntExtra("img",0))
        foodprice.text=intent.getStringExtra("price")
        foodtitle.text=intent.getStringExtra("title")
        ratingbar.rating=((intent.getIntExtra("rating",0)).toFloat())
        cancel.setOnClickListener{
            val i = Intent(this,HomeActivity::class.java)
            startActivity(i)
        }
        if (ContextCompat.checkSelfPermission(this ,android.Manifest.permission.CALL_PHONE
            )!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),100)
        }
        order.setOnClickListener {
            val tel = Intent(Intent.ACTION_CALL, Uri.parse("tel:"+"${intent.getStringExtra("tel")}"))
            startActivity(tel)
            true
        }

    }
}