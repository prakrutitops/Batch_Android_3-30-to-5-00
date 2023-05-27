package com.example.myapplication.Adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.Activity.AdduserActivity
import com.example.myapplication.Database.MyDb
import com.example.myapplication.Entity.User
import com.example.myapplication.R
import com.example.myapplication.globalVariables.GlobalVariables

class MyAdapter(var context: Context,var list: MutableList<User>) :RecyclerView.Adapter<Myview>()
{

    var db: MyDb? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview {

        context = parent.getContext()
        db = Room.databaseBuilder(parent.getContext(),
            MyDb::class.java, "myDatabase").allowMainThreadQueries().build()
        val v: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.design, parent, false)
        return Myview(v)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: Myview, position: Int)
    {
        holder.txt1.setText(list.get(position).name)
        holder.txt2.setText(list.get(position).pass)

        holder.itemView.setOnClickListener {

            var alert = AlertDialog.Builder(context)
            alert.setTitle("Select Operations?")
            alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

                GlobalVariables.id = list[position].id
                GlobalVariables.name = list[position].name
                GlobalVariables.email = list[position].pass
                GlobalVariables.updateFlag = "update"


                val intent = Intent(context, AdduserActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context!!.startActivity(intent)



            })
            alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

                        deleteuser(list.get(position).id)
                        list.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position, list.size)


            })

            alert.show()

        }

    }

    fun deleteuser(id:Int)
    {
        val user = User()
        user.id = id
        db!!.daoClass().deleteuser(user)
        Toast.makeText(context, "Deleted!", Toast.LENGTH_SHORT).show()
    }

}
class Myview(itemview: View) :RecyclerView.ViewHolder(itemview)
{


    var txt1:TextView = itemview.findViewById(R.id.txt1)
    var txt2:TextView = itemview.findViewById(R.id.txt2)


}