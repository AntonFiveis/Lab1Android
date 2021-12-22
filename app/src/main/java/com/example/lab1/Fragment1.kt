package com.example.lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.textfield.TextInputEditText


class Fragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.okButton).setOnClickListener {
            try {
                print("hello")
                val textInput = view.findViewById<TextInputEditText>(R.id.textInput)
                val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
                val text: String = textInput.text.toString()
                val selectedOption: Int = radioGroup!!.checkedRadioButtonId
                val bundle = Bundle()
                if (selectedOption != -1 && text != "") {
                    val radioButton = view.findViewById<RadioButton>(selectedOption)

                    val color = radioButton.text.toString()

                    val f2 = Fragment2();
                    bundle.putString("fragment_text", text)
                    bundle.putString("fragment_text_color", color)
                    f2.arguments = bundle
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.fragmentContainerView2, f2)?.addToBackStack(null)?.commit()
                } else {
                    Toast.makeText(
                        activity,
                        "Завершити введення всіх даних.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }

}

