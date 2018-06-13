package com.cibertec.mamahelp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        print("test")
        btn_login_submit.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        val i = view!!.id

        if(i == R.id.btn_login_submit) {
            signIn(inputEmail.text.toString(), inputPassword.text.toString())
        }
    }

    private fun signIn(email: String, password: String){
        print(email)
        print(password)
    }

}
