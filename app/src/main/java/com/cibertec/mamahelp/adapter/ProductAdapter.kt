package com.cibertec.mamahelp.adapter

import android.content.Context
import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.cibertec.mamahelp.data.Product
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.cibertec.mamahelp.R
import com.squareup.picasso.Picasso
import org.jetbrains.anko.imageResource
import org.w3c.dom.Text

class ProductAdapter(private val context :Context,
                     private var items: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.product_list_row, parent, false)
        return ViewHolder(v)

        //return ViewHolder(layoutInflater.inflate(R.layout.product_list_row, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titulo.text = items[position].titulo
        val precio = "%.2f".format(items[position].precio)
        val precioFinal = context.getString(R.string.precio, precio)
        holder.precio.text = precioFinal
        Picasso.get().load( items[position].imageUrl)
                .into(holder.image)
        print(holder)
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {

        val titulo: TextView
        val precio: TextView
        val image: ImageView

        init {
            titulo = row.findViewById(R.id.tv_titulo) as TextView
            precio = row.findViewById(R.id.tv_precio) as TextView
            image = row.findViewById(R.id.product_list_image) as ImageView
        }

    }
}