package com.example.pizzarestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_user)

        val userId = intent.getStringExtra("NAME")
        val storeLocation = intent.getStringExtra("LOCATION")

        val userIdTextView = findViewById<TextView>(R.id.user_id)
        val locationTextView = findViewById<TextView>(R.id.location_textView)

        userIdTextView.text = "Hello, $userId"
        locationTextView.text = storeLocation

        val btnSeeMenus = findViewById<Button>(R.id.see_menu_id)
        btnSeeMenus?.setOnClickListener {
            val intent = Intent(this, MenuViews::class.java)
            intent.putExtra("USER_ID", userId)
            intent.putExtra("STORE_LOCATION", storeLocation)
            startActivity(intent)
        }
    }
}
