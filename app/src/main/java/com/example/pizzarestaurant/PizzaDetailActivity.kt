package com.example.pizzarestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PizzaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detail)
        val userId = intent.getStringExtra("USER_ID")
        val storeLocation = intent.getStringExtra("STORE_LOCATION")

        val selectedFood = intent.getStringExtra("FOOD_NAME")

        val orderButton = findViewById<Button>(R.id.oder_id_button)
        orderButton.setOnClickListener {
            val intent = Intent(this, OrderDetails::class.java)
            intent.putExtra("SELECTED_FOOD", selectedFood)
            intent.putExtra("USER_ID",userId)
            intent.putExtra("STORE_LOCATION",storeLocation)
            startActivity(intent)
        }

        val backButton = findViewById<Button>(R.id.back_id_button)
        backButton.setOnClickListener {
            val intent = Intent(this, MenuViews::class.java)
            startActivity(intent)
        }
    }
}