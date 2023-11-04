package com.example.pizzarestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class OrderDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        val checkBoxAmbilSendiri = findViewById<CheckBox>(R.id.checkbox_ambil_sendiri)
        val checkBoxFastDelivery = findViewById<CheckBox>(R.id.checkbox_fast_delivery)
        val doneButton = findViewById<Button>(R.id.done_id_button)

        val userIdTextView = findViewById<TextView>(R.id.user_id)
        val locationTextView = findViewById<TextView>(R.id.location_textView)
        val orderTextView = findViewById<TextView>(R.id.order_textView)

        val userId: String = intent.getStringExtra("USER_ID") ?: "TestUser"
        val storeLocation = intent.getStringExtra("STORE_LOCATION")
        val foodItem: String = intent.getStringExtra("SELECTED_FOOD") ?: "TestFood"

        userIdTextView.text = userId
        locationTextView.text = storeLocation
        orderTextView.text = "Pesanan: $foodItem"


        doneButton.setOnClickListener {
            if (checkBoxAmbilSendiri.isChecked && checkBoxFastDelivery.isChecked) {
                showToast("Pilih hanya satu opsi: Ambil Sendiri atau Fast Delivery.")
            } else if (!checkBoxAmbilSendiri.isChecked && !checkBoxFastDelivery.isChecked) {
                showToast("Pilih salah satu opsi: Ambil Sendiri atau Fast Delivery.")
            } else {
                val toastMessage = buildToastMessage(userId, foodItem, checkBoxAmbilSendiri.isChecked, checkBoxFastDelivery.isChecked)
                showToast(toastMessage)
            }
        }

    }

    private fun buildToastMessage(userId: String, foodItem: String, ambilSendiriChecked: Boolean, fastDeliveryChecked: Boolean): String {
        val stringBuilder = StringBuilder("Terima kasih $userId sudah memesan\nditoko kami. Pesanan $foodItem ")

        if (ambilSendiriChecked) {
            stringBuilder.append("akan anda ambil sendiri.\n")
        }

        if (fastDeliveryChecked) {
            stringBuilder.append(". Pesanan anda akan dikirim menggunakan Fast Delivery.\n")
        }

        return stringBuilder.toString()
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
