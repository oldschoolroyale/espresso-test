package com.brm.espressotest.samplefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brm.espressotest.R

/**
 * Created by Rakhimjonov Shokhsulton on 18,июль,2022
 * at Mayasoft LLC,
 * Tashkent, UZB.
 */
class SampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample, container, false)
    }

}