package com.example.dia4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.fragment_begin.*

class BeginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_begin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var mainActivity = (activity as AppCompatActivity)
        mainActivity.supportActionBar?.title = "Empezar"


        btn_begin.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.frame_main, ExerciseTypeFragment())?.addToBackStack("beginFragment")?.commit()
        }
    }
}
