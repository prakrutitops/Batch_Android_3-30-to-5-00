package com.example.recyclerviewex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list: MutableList<Model>) :RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
      var inflater = LayoutInflater.from(context)
      var view = inflater.inflate(R.layout.design,parent,false)
      return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.image.setImageResource(list.get(position).image)
        holder.text1.setText(list.get(position).name)
        holder.text2.setText(list.get(position).price)
    }

    override fun getItemCount(): Int
    {
       return list.size
    }

}
class MyView(itemview: View) :RecyclerView.ViewHolder(itemview)
{

    var image:ImageView
    var text1:TextView
    var text2:TextView

    init
    {

        image = itemview.findViewById(R.id.img)
        text1 = itemview.findViewById(R.id.txt1)
        text2 = itemview.findViewById(R.id.txt2)
    }





}
