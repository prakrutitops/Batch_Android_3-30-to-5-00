package com.example.realmex

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MyApplication :Application()
{

    override fun onCreate()
    {
        super.onCreate()

        //initialization of realm
        Realm.init(this)

        //configuration db file
        var configuration= RealmConfiguration.Builder()
            .name("user.db")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()

        //Set realm configuration
        Realm.setDefaultConfiguration(configuration)
    }

}