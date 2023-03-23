package com.example.tablayoutproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tablayoutproject.databinding.FragmentCallBinding

class CallFragment : Fragment() {

    private var _binding: FragmentCallBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCallBinding.inflate(inflater, container, false)
        val view = _binding!!.root


  /*      val bundle = Bundle()
        bundle.getString("message", "")*/

// Set Fragmentclass Arguments

// Set Fragmentclass Arguments



        return view
    }


}