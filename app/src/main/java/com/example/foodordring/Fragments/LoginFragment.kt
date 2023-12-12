package com.example.foodordring.Fragments

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.foodordring.R
import com.example.foodordring.ui.Login.LoginActivity
import com.example.foodordring.ui.home.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_signup.*

@Suppress("UNREACHABLE_CODE")
class LoginFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_login, container, false)
        view.showHideBtn.setOnClickListener {
            if (view.showHideBtn.text.toString().equals("show")) {
                view.input_password_login.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                view.showHideBtn.setBackgroundResource(R.drawable.hidden_pwd)
                view.showHideBtn.text = "hide"
                ;
            } else {
                view.input_password_login.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                view.showHideBtn.setBackgroundResource(R.drawable.show_pwd)
                view.showHideBtn.text = "show"
            }
        }



        firebaseAuth= FirebaseAuth.getInstance()
        view.login_btn.setOnClickListener{
            val email=view.EmailInputlogin.text.toString()
            val password=view.input_password_login.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val Loginintent= Intent(activity, HomeActivity::class.java)
                        startActivity(Loginintent)
                    }else{
                        Toast.makeText(activity,it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            }else{
                Toast.makeText(activity,"Empty Fields are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
        // Return the fragment view/layout
            return view
        }

}