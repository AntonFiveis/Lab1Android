package com.example.lab1

import android.content.Context.MODE_APPEND
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import java.io.FileInputStream
import java.io.FileOutputStream


class Fragment1 : Fragment() {
    private final var fileName = "db.txt"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_1, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val fileOutput: FileOutputStream? = context?.openFileOutput(fileName, 0)
        fileOutput?.write("".toByteArray())

        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.okButton).setOnClickListener {
            try {
                val textInput = view.findViewById<TextInputEditText>(R.id.textInput)
                val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
                val text: String = textInput.text.toString()
                val selectedOption: Int = radioGroup!!.checkedRadioButtonId
                val bundle = Bundle()
                val fileOutput: FileOutputStream? = context?.openFileOutput(fileName,MODE_APPEND)
                fileOutput?.write(text.toByteArray())
                fileOutput?.write("\n".toByteArray())
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

        view.findViewById<Button>(R.id.showButton).setOnClickListener{
            val intent = Intent(activity, Activity2::class.java)
            val result: String? = readFile()
            intent.putExtra("dbResult", result)
            startActivity(intent)
        }
    }

    private fun readFile(): String? {

        context?.openFileInput(fileName).use { stream ->
            val savedData = stream?.bufferedReader().use {
                it?.readText()
            }
            return savedData
        }

    }

}


