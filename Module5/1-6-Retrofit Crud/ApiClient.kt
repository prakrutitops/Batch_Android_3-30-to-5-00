package com.example.retrofitcrud

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {

        var url ="https://vyasprakruti.000webhostapp.com/mobileapi/"

        lateinit var retrofit: Retrofit

        fun getapiclient() :Retrofit
        {
            retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return  retrofit
        }


    }
}