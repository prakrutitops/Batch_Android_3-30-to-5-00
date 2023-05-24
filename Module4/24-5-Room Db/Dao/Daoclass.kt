package com.example.myapplication.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.Entity.User

@Dao
interface Daoclass
{

    @Insert
    fun insertdata(user: User?)

    @Query("select * from user")
    fun getUsers(): MutableList<User>
}