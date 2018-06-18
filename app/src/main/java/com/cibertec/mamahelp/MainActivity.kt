package com.cibertec.mamahelp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.cibertec.mamahelp.data.Product
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton
import java.io.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_login_submit.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        var gson = Gson()
        val inputStream:InputStream = assets.open("products.json")

        val json = """{"titulo": "Kolineer", "codigo": "26", "precio" : 34}"""

        val products: Product = gson.fromJson(json, Product::class.java)
        
        val i = view!!.id
        if(i == R.id.btn_login_submit) {
            signIn(inputEmail.text.toString(), inputPassword.text.toString())
        }
    }

    private fun signIn(email: String, password: String){

        if(email.equals("1",true) && password.equals("1",true)){
            val intent = Intent(this, ProductActivity::class.java)
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
