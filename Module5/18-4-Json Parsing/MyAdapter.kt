package com.example.jsonex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MyAdapter(var context: Context,var list: MutableList<Model>) :BaseAdapter()
{
    override fun getCount(): Int
    {
            return  list.size
    }

    override fun getItem(position: Int): Any
    {
        return  position
    }

    override fun getItemId(position: Int): Long
    {
      return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var layout =LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,parent,false)
        var txt1:TextView = view.findViewById(R.id.txt1)
        var txt2:TextView = view.findViewById(R.id.txt2)
        var txt3:TextView = view.findViewById(R.id.txt3)
        var image:ImageView = view.findViewById(R.id.img)


        txt1.setText(list.get(position).name)
        txt2.setText(list.get(position).price)
        txt3.setText(list.get(position).des)

        Picasso.get().load(list.get(position).image).placeholder(R.mipmap.ic_launcher).into(image)

        return view
    }

}