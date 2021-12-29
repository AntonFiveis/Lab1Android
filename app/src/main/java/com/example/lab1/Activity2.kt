package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val resultField = findViewById<TextView>(R.id.textViewFile)
        var output = intent.getStringExtra("dbResult")
        if(output?.length ==0 ) {
            output = "There are no data!"
        }
        resultField.text = output
    }


}