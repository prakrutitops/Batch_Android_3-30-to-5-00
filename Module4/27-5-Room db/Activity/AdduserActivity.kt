package com.example.myapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.myapplication.Database.MyDb
import com.example.myapplication.Entity.User
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAdduserBinding
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.globalVariables.GlobalVariables

class AdduserActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAdduserBinding
    var db: MyDb? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        db = Room.databaseBuilder(applicationContext,
            MyDb::class.java, "myDatabase").allowMainThreadQueries().build()

        if (GlobalVariables.updateFlag.equals("update"))
        {
            binding.edtname.setText(GlobalVariables.name)
            binding.edtpass.setText(GlobalVariables.email)
        }
        binding.btninsert.setOnClickListener {

            var name = binding.edtname.text.toString()
            var pass = binding.edtpass.text.toString()

            if(GlobalVariables.updateFlag.equals("update"))
            {
                var u = User()
                u.id=GlobalVariables.id
                u.name=name
                u.pass=pass

                db!!.daoClass().updateuser(u)
                Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show();
                GlobalVariables.updateFlag = "";

                startActivity(Intent(this,MainActivity::class.java))

            }
            else
            {


                var m = User()
                m.name=name
                m.pass=pass

                db!!.daoClass().insertdata(m)
                Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()
            }








        }

        binding.btnview.setOnClickListener {

            startActivity(Intent(applicationContext,MainActivity::class.java))

        }
    }
}