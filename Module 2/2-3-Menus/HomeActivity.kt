package com.example.myapplication

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CAMERA
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    lateinit var chk1:CheckBox
    lateinit var chk2:CheckBox
    lateinit var chk3:CheckBox
    lateinit var btn1:Button
    lateinit var txt1:TextView
    lateinit var txt3:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)
        chk3 = findViewById(R.id.chk3)
        btn1 = findViewById(R.id.btn1)
        txt1 = findViewById(R.id.txt2)
        txt3 = findViewById(R.id.txt3)

        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE),101)

        }
        registerForContextMenu(txt1)
        txt3.setOnClickListener {

                var popup = PopupMenu(applicationContext,txt3)
                popup.menuInflater.inflate(R.menu.popup_menu,popup.menu)
                popup.setOnMenuItemClickListener(this)
                popup.show()
        }
        btn1.setOnClickListener {

                var amount = 0
                var builder = StringBuilder("")
                builder.append("\n selected Items \n")


               if(chk1.isChecked)
               {
                   builder.append("\n Pizza @ Rs. 100 \n")
                   amount+=100
               }
                if(chk2.isChecked)
                {
                    builder.append("\n Burger @ Rs. 70 \n")
                    amount+=70
                }
                if(chk3.isChecked)
                {
                    builder.append("\n Coffee @ Rs. 120 \n")
                    amount+=120
                }
                builder.append("\n Total: "+amount)

                //Toast.makeText(applicationContext,""+builder.toString(),Toast.LENGTH_LONG).show()
                //Log.d("BILL",builder.toString())

                var i = Intent(applicationContext,BillActivity::class.java)
                i.putExtra("BILL",builder.toString())
                startActivity(i)


        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {

            R.id.i2->
            {
                try
                {
                    var num="9999999999"
                    var i = Intent(Intent.ACTION_CALL)
                    i.setData(Uri.parse("tel:"+num))
                    startActivity(i)
                }
                catch(e:Exception)
                {
                    Toast.makeText(applicationContext,"Please Allow Permission For Call",Toast.LENGTH_LONG).show()
                }

            }
            R.id.i1->
            {
                finishAffinity()
            }


        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext,"Position called",Toast.LENGTH_LONG).show()
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when(item!!.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext,"Data Called",Toast.LENGTH_LONG).show()
            }
        }

        return false
    }
}