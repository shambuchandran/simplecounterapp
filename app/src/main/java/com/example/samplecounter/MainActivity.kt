package com.example.samplecounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val count = findViewById<TextView>(R.id.counttxt)
        val minus = findViewById<Button>(R.id.minusbtn)
        val plus = findViewById<Button>(R.id.plusbtn)
        val reset = findViewById<Button>(R.id.resetbtn)
        var counter = 0
        minus.setOnClickListener {
            if (counter != 0) {
                counter--
                count.text = counter.toString()
            } else {
                Toast.makeText(this, "can't go back", Toast.LENGTH_LONG).show()
            }
        }
        plus.setOnClickListener {
            counter++
            count.text = counter.toString()
        }
        reset.setOnClickListener {
            counter = 0
            count.text = "START"
        }

    }
}