package com.example.myapplication

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder

class MyAdapter(var context: Context,options: FirebaseRecyclerOptions<Model>) : FirebaseRecyclerAdapter<Model,myviewholder>(options)
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder
    {
        val view: View = LayoutInflater.from(parent.getContext()).inflate(R.layout.design, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int, model: Model)
    {
        holder.name.setText(model.name)
        holder.email.setText(model.email)
            holder.pass.setText(model.pass)

        holder.edit.setOnClickListener {


                var dialog = DialogPlus.newDialog(holder.edit.context)
                    .setContentHolder(ViewHolder(R.layout.dialogcontent))
                    .setExpanded(true, 1100)
                    .create()
                    val view = dialog.holderView
                    val name = view.findViewById<EditText>(R.id.edt1)
                    val email = view.findViewById<EditText>(R.id.edt2)
                    val pass = view.findViewById<EditText>(R.id.edt3)
                    val submit = view.findViewById<Button>(R.id.btnupdate)

                    name.setText(model.name)
                    email.setText(model.email)
                    pass.setText(model.pass)

                    submit.setOnClickListener {

                        var name1 = name.text.toString()
                        var email1 = email.text.toString()
                        var pass1 = pass.text.toString()

                        var map = HashMap<String,Any>()
                        map["name"]=name1
                        map["email"]=email1
                        map["pass"]=pass1

                        var db = FirebaseDatabase.getInstance().getReference()
                            .child("info") .child(getRef(position).key!!).
                            updateChildren(map)

                            .addOnSuccessListener()
                            {
                                Toast.makeText(context,"Success", Toast.LENGTH_LONG).show()
                                var i = Intent(context,MainActivity::class.java)
                                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                context.startActivity(i)
                            }
                            .addOnFailureListener()
                            {
                                Toast.makeText(context,"Fail", Toast.LENGTH_LONG).show()
                            }


                    }


                dialog.show()


        }
        holder.delete.setOnClickListener {

                var alertDialog = AlertDialog.Builder(holder.delete.context)
                alertDialog.setTitle("DELETE?")
                alertDialog.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                    FirebaseDatabase.getInstance().getReference().child("info")
                        .child(getRef(position).getKey()!!)
                        .removeValue()

                })
                alertDialog.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()

                })
            alertDialog.show()
        }
    }

}
class myviewholder(itemview: View) :RecyclerView.ViewHolder(itemview)
{
    var name: TextView
    var pass: TextView
    var email: TextView
    var edit:ImageView
    var delete:ImageView
    init
    {

        name = itemView.findViewById(R.id.txt1)
        email = itemView.findViewById(R.id.txt2)
        pass = itemView.findViewById(R.id.txt3)
        edit = itemView.findViewById(R.id.img1)
        delete = itemView.findViewById(R.id.img2)

    }

}