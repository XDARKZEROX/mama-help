package com.cibertec.mamahelp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.yesButton

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login_submit.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val i = view!!.id
        if(i == R.id.btn_login_submit) {
            signIn(inputEmail.text.toString(), inputPassword.text.toString())
        }
    }

    private fun signIn(email: String, password: String){

        if(email.equals("1",true) && password.equals("1",true)){
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        } else {
            alert ("El correo o clave que ingresaste son incorrectos") {
                title = "Mama Help says:"
                yesButton { }
                noButton { }
            }.show()
        }
    }

    private fun signUp(){

    }

}
