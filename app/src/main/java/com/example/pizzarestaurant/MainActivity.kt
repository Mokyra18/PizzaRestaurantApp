package com.example.pizzarestaurant

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.locations_spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.locations_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        val btnSubmit = findViewById<Button>(R.id.submit_id_button)
        btnSubmit?.setOnClickListener(View.OnClickListener {
            val selectedLocation = spinner.selectedItem.toString()

            val inputName = findViewById<EditText>(R.id.input_nama).text.toString()

            val intent = Intent(this, LoginUser::class.java)

            intent.putExtra("LOCATION", selectedLocation)
            intent.putExtra("NAME", inputName)

            startActivity(intent)
        })
    }
}
