package com.example.woworkslidernav

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_pager.*
import java.net.URI

/**
 * A simple [Fragment] subclass.
 */
class PagerFragment : Fragment() {


    companion object {

        @JvmStatic
        fun newInstance(title: String, text: String, image: Int) = PagerFragment().apply {
            arguments = Bundle().apply {
                putString("title", title)
                putString("text", text)
                putInt("image", image)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val args = this.arguments
        //set title
        val titleReceived = arguments?.getString("title").toString()
        fragment_title.text = titleReceived
        //set text
        val textReceived = arguments?.getString("text").toString()
        fragment_text.text = textReceived
        //set image
        val imageReceived = arguments?.getInt("image")
        fragment_pager_image.setBackgroundResource(imageReceived!!)
    }


}
