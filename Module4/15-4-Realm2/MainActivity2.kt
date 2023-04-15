package com.example.realmex

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.realmex.databinding.ActivityMain2Binding
import io.realm.Realm
import io.realm.RealmResults

class MainActivity2 : AppCompatActivity(), OnItemClickListener {

    private lateinit var binding: ActivityMain2Binding
    lateinit var list: MutableList<Model>
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        list = ArrayList()

        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        realm.beginTransaction()

            var results :RealmResults<Model> = realm.where(Model::class.java).findAll()

            for(i in results.indices)
            {
                list.add(results[i]!!)
            }

            var adapter = MyAdapter(applicationContext,list)
            binding.list.adapter = adapter

        realm.commitTransaction()
        binding.list.setOnItemClickListener(this)

    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
    {
        var alert = AlertDialog.Builder(this)
        alert.setTitle("Select Operations?")
        alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->


            var alert2 = AlertDialog.Builder(this)
            var layout = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.activity_update,null)
            alert2.setView(view)
            var edt1:EditText= view.findViewById(R.id.edt1)
            var edt2:EditText= view.findViewById(R.id.edt2)
            edt1.setText( list.get(position).name)
            edt2.setText( list.get(position).pass)
            alert2.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->


                var name =edt1.text.toString()
                var pass=edt2.text.toString()

                realm.beginTransaction()

                list.get(position).name =name
                list.get(position).pass =pass


                realm.commitTransaction()
                startActivity(Intent(this,MainActivity2::class.java))
            })





            alert2.show()


        })
        alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

            realm.beginTransaction()
            var deleteresults :RealmResults<Model> = realm.where(Model::class.java).findAll()
            deleteresults.deleteFromRealm(position)
            realm.commitTransaction()
            startActivity(Intent(applicationContext,MainActivity2::class.java))
        })
        alert.show()
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}