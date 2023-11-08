package com.example.a3.cityInfoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.a3.R

class NameFragment : Fragment() {
    companion object {
        fun newInstance(name: String): NameFragment {
            val fragment = NameFragment()
            val args = Bundle()
            args.putString("Name", name)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameFragment = view.findViewById<TextView>(R.id.nameFragment)

        // Get the name from the arguments and set it to the TextView
        val name = arguments?.getString("Name")
        nameFragment.text = name
    }
}
