package com.cibertec.mamahelp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.cibertec.mamahelp.adapter.ProductAdapter
import com.cibertec.mamahelp.data.Product
import kotlinx.android.synthetic.main.activity_product.*
import android.support.v7.widget.GridLayoutManager




class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val productList = Product.getRecipesFromFile("products.json", this)

        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerList.layoutManager = gridLayoutManager

        //recyclerList.layoutManager = LinearLayoutManager(this)
        recyclerList.hasFixedSize()
        recyclerList.adapter = ProductAdapter(this, productList)

    }
}
