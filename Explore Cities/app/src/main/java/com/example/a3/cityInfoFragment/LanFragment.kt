package com.example.a3.cityInfoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.a3.R

class LanFragment : Fragment() {
    companion object {
        fun newInstance(lan: String): LanFragment {
            val fragment = LanFragment()
            val args = Bundle()
            args.putString("lan", lan)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lanFragment = view.findViewById<TextView>(R.id.lanfrag)

        // Get the name from the arguments and set it to the TextView
        val lan = arguments?.getString("lan")
        lanFragment.text = lan
    }
}
