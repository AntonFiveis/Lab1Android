package com.example.lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class Fragment2 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        print("hello")
        val fragment_text = arguments?.getString("fragment_text")
        val color = arguments?.getString("fragment_text_color")
        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = fragment_text
        if (color == "Purple")
            textView.setTextColor(getResources().getColor(R.color.purple_200))
        else if (color == "Teal")
            textView.setTextColor(getResources().getColor(R.color.teal_200))
        else if (color == "Blue")
            textView.setTextColor(getResources().getColor(R.color.purple_700))

        view.findViewById<Button>(R.id.cancelButton).setOnClickListener {
            val textView = view.findViewById<TextView>(R.id.textView)
            textView.text = ""
        }
    }

}