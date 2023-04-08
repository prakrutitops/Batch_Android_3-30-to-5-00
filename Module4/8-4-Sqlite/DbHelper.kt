package com.example.sqliteex

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(var context: Context) :SQLiteOpenHelper(context,DB_NAME,null,DB_VERSION)
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

}