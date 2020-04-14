package com.example.dia4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dia4.MainActivity.fOnBackPressed
import kotlinx.android.synthetic.main.fragment_exercise_plan.*
//import sun.jvm.hotspot.utilities.IntArray


/**
 * A simple [Fragment] subclass.
 */
class ExercisePlanFragment : Fragment(), fOnBackPressed {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_plan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Exercise Type"

        btn_backToType.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        btn_goToReady.setOnClickListener {
            fragmentManager?.beginTransaction()?.replace(R.id.frame_main, ExerciseReadyFragment())?.addToBackStack("planFragment")?.commit()
        }
    }
    override fun onBackPressed(): Boolean {
        fragmentManager?.popBackStack()
        return true

    }

}
