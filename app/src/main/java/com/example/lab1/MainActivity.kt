package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import android.widget.Toast




class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView;
    private lateinit var radioGroup: RadioGroup;
    private lateinit var radioButton: RadioButton;
    private lateinit var textInput: TextInputEditText;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        radioGroup = findViewById(R.id.radioGroup)
        textInput = findViewById(R.id.textInput)
        textView.setText("")

    }

    fun showText(view: View) {
        val text: String = textInput.text.toString()
        val selectedOption: Int = radioGroup!!.checkedRadioButtonId
        textView.setText(text)
        if(selectedOption != -1 && text!="") {
            radioButton = findViewById(selectedOption)

            val color = radioButton.text.toString()
            if (color == "Purple")
                textView.setTextColor(getResources().getColor(R.color.purple_200))
            else if (color == "Teal")
                textView.setTextColor(getResources().getColor(R.color.teal_200))
            else if (color == "Blue")
                textView.setTextColor(getResources().getColor(R.color.purple_700))
        }
        else{
            val toast = Toast.makeText(this@MainActivity, "Завершити введення всіх даних.", Toast.LENGTH_LONG)
            toast.show()
        }
    }
    fun hideText(view: View) {
        textView.setText("")
    }
}
