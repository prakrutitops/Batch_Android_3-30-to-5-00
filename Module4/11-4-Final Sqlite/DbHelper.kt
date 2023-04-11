package com.example.sqliteex

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(context: Context) : SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION)
{
    companion object
    {
        var DB_NAME="user.db"
        var TABLE_NAME="info"
        var ID="id"
        var NAME="name"
        var NUMBER="number"
        var DB_VERSION=1
    }


    override fun onCreate(db: SQLiteDatabase?)
    {
        var query ="CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"+ NUMBER + " TEXT" + ")"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int)
    {
        var upqery="DROP TABLE IF EXISTS "+ TABLE_NAME
        db!!.execSQL(upqery)
    }

    //contentvalues - data save
    fun savedata(m:Model):Long
    {
        var db = writableDatabase
        var values = ContentValues()
        values.put(NAME,m.name)
        values.put(NUMBER,m.num)
        var id = db.insert(TABLE_NAME,ID,values)
        return id
    }
    //Cursor - data view
    fun viewdata(): ArrayList<Model>
    {
        var db = readableDatabase
        var list = ArrayList<Model>()
        var col = arrayOf(ID, NAME, NUMBER)
        var cursor:Cursor = db.query(TABLE_NAME,col,null,null,null,null,null,null)//select * from tablename

        while (cursor.moveToNext())
        {
            var id1 = cursor.getInt(0)
            var name1= cursor.getString(1)
            var num1 = cursor.getString(2)

            var m = Model()
            m.id=id1
            m.name=name1
            m.num =num1

            list.add(m)


        }
        return list
    }
    fun deletedata(id:Int)
    {
        var db = writableDatabase
        var deletequery = "ID"+"="+id
        db.delete(TABLE_NAME,deletequery,null)
    }
    fun updatedata(m:Model)
    {
        var db = writableDatabase
        var values = ContentValues()
        values.put(ID,m.id)
        values.put(NAME,m.name)
        values.put(NUMBER,m.num)
        var updatequery = "ID"+"="+m.id
        db.update(TABLE_NAME,values,updatequery,null)

    }



}