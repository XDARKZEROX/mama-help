package com.cibertec.mamahelp.data

import android.content.Context
import org.json.JSONException
import org.json.JSONObject

class Product(
        val titulo: String, val precio: Double, val imageUrl: String) {

    companion object {

        fun getRecipesFromFile(filename: String, context: Context): ArrayList<Product> {
            val productList = ArrayList<Product>()

            try {
                // Load data
                val jsonString = loadJsonFromAsset(filename, context)
                val json = JSONObject(jsonString)
                val products = json.getJSONArray("products")

                // Get Recipe objects from data
                (0 until products.length()).mapTo(productList) {
                    Product(products.getJSONObject(it).getString("titulo"),
                            products.getJSONObject(it).getDouble("precio"),
                            products.getJSONObject(it).getString("image")
                            )
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            return productList
        }

        private fun loadJsonFromAsset(filename: String, context: Context): String? {
            var json: String? = null

            try {
                val inputStream = context.assets.open(filename)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                json = String(buffer, Charsets.UTF_8)
            } catch (ex: java.io.IOException) {
                ex.printStackTrace()
                return null
            }

            return json
        }
    }


}