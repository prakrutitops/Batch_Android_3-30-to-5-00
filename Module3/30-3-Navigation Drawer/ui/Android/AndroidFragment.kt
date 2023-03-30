package com.example.myapplication.ui.Android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.example.myapplication.Model
import com.example.myapplication.MyAdapter

import com.example.myapplication.R


class AndroidFragment : Fragment() {

    lateinit var listView: GridView
    lateinit var list: MutableList<Model>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_android, container, false)

        listView = view.findViewById(R.id.list)
        list = ArrayList()
        list.add(Model(R.drawable.image1,"Burger","30 min"))
        list.add(Model(R.drawable.image2,"Pizza","15 min"))
        list.add(Model(R.drawable.image3,"Coffee","45 min"))
        list.add(Model(R.drawable.image1,"Burger","30 min"))
        list.add(Model(R.drawable.image2,"Pizza","15 min"))
        list.add(Model(R.drawable.image3,"Coffee","45 min"))
        list.add(Model(R.drawable.image1,"Burger","30 min"))
        list.add(Model(R.drawable.image2,"Pizza","15 min"))
        list.add(Model(R.drawable.image3,"Coffee","45 min"))
        list.add(Model(R.drawable.image1,"Burger","30 min"))
        list.add(Model(R.drawable.image2,"Pizza","15 min"))
        list.add(Model(R.drawable.image3,"Coffee","45 min"))

        var adapter = MyAdapter(activity!!,list)
        listView.adapter=adapter


    return view
    }


    }


