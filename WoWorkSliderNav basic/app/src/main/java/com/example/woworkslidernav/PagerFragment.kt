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

//    private var receivedTitle = ""
//    private var receivedText = ""
//
//    companion object {
//
//        @JvmStatic
//        fun newInstance(title: String, text: String) = PagerFragment().apply {
//            arguments = Bundle().apply {
//                putString("title", title)
//                putString("text", text)
//            }
//        }
//    }

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
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        val args = this.arguments
//        receivedTitle = args?.getString("title").toString()
//        Log.i("iiiiiiiiii", "$receivedTitle")
//
//    }
//
//
////    override fun onAttach(context: Context) {
////        super.onAttach(context)
////        arguments?.getString("title")?.let {
////            Log.i("iiiiiiiiii", "$it")
//////            fragment_title.text = it
////
////        }
////    }
}
