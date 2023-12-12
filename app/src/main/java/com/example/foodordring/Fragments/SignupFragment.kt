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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlinx.android.synthetic.main.fragment_signup.view.*

class SignupFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_signup, container, false)

        view.showHideBtn_signupscene.setOnClickListener {
            if (view.showHideBtn_signupscene.text.toString().equals("show")) {
                view.input_password_signup.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                view.showHideBtn_signupscene.setBackgroundResource(R.drawable.hidden_pwd)
                view.showHideBtn_signupscene.text = "hide"
                ;
            } else {
                view.input_password_signup.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                view.showHideBtn_signupscene.setBackgroundResource(R.drawable.show_pwd)
                view.showHideBtn_signupscene.text = "show"
            }
        }

        firebaseAuth= FirebaseAuth.getInstance()
        view.register_btn.setOnClickListener{
            val email=view.EmailInput.text.toString()
            val password=view.input_password_signup.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                    if(it.isSuccessful){
                        Toast.makeText(activity,"Account created!",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(activity,it.exception.toString(),Toast.LENGTH_SHORT).show()

                    }
                }
            }else{
                Toast.makeText(activity,"Empty Fields are not Allowed !!",Toast.LENGTH_SHORT).show()
            }
        }

        // Return the fragment view/layout
        return view
    }


}
