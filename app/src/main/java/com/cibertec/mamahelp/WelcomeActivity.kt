package com.cibertec.mamahelp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        btn_welcome.setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        val i = view!!.id
        if(i == R.id.btn_welcome) {
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }
    }

}
