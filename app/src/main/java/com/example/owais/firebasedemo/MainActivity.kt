package com.example.owais.firebasedemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    private var mAuth:FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        mAuth = FirebaseAuth.getInstance()
    }

    fun loginEvent(view:View){
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        loginToFireBase(email,password)

    }

    fun loginToFireBase(email:String,password:String){
        mAuth!!.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(){task ->
                if(task.isSuccessful){
                    Toast.makeText(applicationContext,"Login Successfull",Toast.LENGTH_SHORT).show()
                    var currentUser = mAuth!!.currentUser
                    Log.d("Login",currentUser!!.uid)
                }
                else{
                    Toast.makeText(applicationContext,"Login failed",Toast.LENGTH_SHORT).show()
                }
            }
    }
}
