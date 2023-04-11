package com.example.sqliteex

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>
    lateinit var dbHelper: DbHelper
    lateinit var arrayList: ArrayList<HashMap<String,String>>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        listView = findViewById(R.id.list)
        list = ArrayList()
        dbHelper = DbHelper(applicationContext)
        registerForContextMenu(listView)
        list = dbHelper.viewdata()
        arrayList = ArrayList()
        var from= arrayOf("NAME","NUMBER")
        var to= intArrayOf(R.id.txt1,R.id.txt2)

        for(i in list)
        {
                var map = HashMap<String,String>()
                map["NAME"]=i.name
                map["NUMBER"]=i.num

            arrayList.add(map)
        }


        var adapter = SimpleAdapter(applicationContext,arrayList,R.layout.design,from,to)
        listView.adapter=adapter
    }

    override fun onBackPressed() {
        finishAffinity()
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1 = menu!!.add(0,1,0,"Update")
        var m2 = menu!!.add(0,2,0,"Delete")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id = acm.position
        val user = list!![id]

        when(item.itemId)
        {
            1->
            {
                //update
                var i = Intent(applicationContext,UpdateActivity::class.java)
                i.putExtra("id",user.id)
                i.putExtra("name",user.name)
                i.putExtra("num",user.num)
                startActivity(i)


            }
            2->
            {
                //delete
                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setTitle("Are you sure you want to delete?")
                alertDialog.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                    dbHelper.deletedata(user.id)
                    startActivity(Intent(applicationContext,MainActivity2::class.java))

                })
                alertDialog.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()
                })
                alertDialog.show()
            }
        }


        return super.onContextItemSelected(item)
    }

}