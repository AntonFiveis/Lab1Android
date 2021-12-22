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
    private lateinit var radioGroup: RadioGroup;
    private lateinit var radioButton: RadioButton;
    private lateinit var textInput: TextInputEditText;
    private lateinit var f1: Fragment1;
    private lateinit var f2: Fragment2;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        textInput = findViewById(R.id.textInput)

    }

    fun showText(view: View) {
        try {
            val text: String = textInput.text.toString()
            val selectedOption: Int = radioGroup!!.checkedRadioButtonId
            val bundle = Bundle()
            if (selectedOption != -1 && text != "") {
                radioButton = findViewById(selectedOption)

                val color = radioButton.text.toString()
                f1 = Fragment1();
                bundle.putString("fragment_text", text)
                bundle.putString("fragment_text_color", color)
                f1.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, f1).addToBackStack(null).commit()
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "Завершити введення всіх даних.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun hideText(view: View) {
        f2 = Fragment2();
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, f2).addToBackStack(null).commit()
    }
}
