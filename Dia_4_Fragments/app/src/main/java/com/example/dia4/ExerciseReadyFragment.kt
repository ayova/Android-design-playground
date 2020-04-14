package com.example.dia4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_exercise_plan.*
import kotlinx.android.synthetic.main.fragment_exercise_ready.*

/**
 * A simple [Fragment] subclass.
 */
class ExerciseReadyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_ready, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Exercise Ready"

        btn_backToPlan.setOnClickListener {
            fragmentManager?.popBackStack()
        }
    }
}
