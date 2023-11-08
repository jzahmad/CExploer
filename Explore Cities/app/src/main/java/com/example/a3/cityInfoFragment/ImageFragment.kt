package com.example.a3.cityInfoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.a3.R

class ImageFragment : Fragment() {
    companion object {
        fun newInstance(imageResId: Int): ImageFragment {
            val fragment = ImageFragment()
            val args = Bundle()
            args.putInt("imageResId", imageResId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageFragment = view.findViewById<ImageView>(R.id.fragImage)

        // Get the image resource ID from the arguments and set it to the ImageView
        val imageResId = arguments?.getInt("imageResId", 0) // Default to 0 if not found
        if (imageResId != 0) {
            if (imageResId != null) {
                imageFragment.setImageResource(imageResId)
            }
        }
    }
}
