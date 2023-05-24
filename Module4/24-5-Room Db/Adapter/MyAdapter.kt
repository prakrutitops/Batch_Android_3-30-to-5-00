package com.example.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Entity.User
import com.example.myapplication.R

class MyAdapter(var context: Context,var list: MutableList<User>) :RecyclerView.Adapter<Myview>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview {

        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,parent,false)
        return Myview(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: Myview, position: Int)
    {
        holder.txt1.setText(list.get(position).name)
        holder.txt2.setText(list.get(position).pass)
    }

}
class Myview(itemview: View) :RecyclerView.ViewHolder(itemview)
{


    var txt1:TextView = itemview.findViewById(R.id.txt1)
    var txt2:TextView = itemview.findViewById(R.id.txt2)


}