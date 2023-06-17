package com.example.test

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project123.Activity.CategoryActivity
import com.example.project123.Activity.FullScreenImageActivity
import com.example.project123.Model.ArtModel

import com.example.project123.R
import com.squareup.picasso.Picasso


class CategoryAdapter(var context: Context, var mutableList: MutableList<ArtModel>) : RecyclerView.Adapter<ViewHolder2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {
        val view = LayoutInflater.from(context).inflate(R.layout.category_design, parent, false)
        return ViewHolder2(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: ViewHolder2, position: Int)
    {

        Picasso.get().load(mutableList.get(position).image).into(holder.imageView)

        holder.itemView.setOnClickListener {

                var i = Intent(context,FullScreenImageActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                i.putExtra("imageurl",mutableList.get(position).image)
                context.startActivity(i)


        }

    }
}

class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var imageView = itemView.findViewById<ImageView>(R.id.dashboard_img)
}
