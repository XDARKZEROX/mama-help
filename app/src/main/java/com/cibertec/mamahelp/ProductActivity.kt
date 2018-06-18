package com.cibertec.mamahelp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import com.cibertec.mamahelp.adapter.ProductAdapter
import com.cibertec.mamahelp.data.Product
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.activity_welcome.*
import kotlinx.android.synthetic.main.product_list_row.*

class ProductActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val productList = ArrayList<Product>()

        val product = Product("pañales")
        val product2 = Product("biberon")
        productList.add(product)
        productList.add(product2)

        recyclerList.layoutManager = LinearLayoutManager(this)
        recyclerList.setHasFixedSize(true)
        recyclerList.adapter = ProductAdapter(this, productList)

    }
}
