package com.example.project123.Client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {

        var BASE_URL="https://vyasprakruti.000webhostapp.com/Project123/"
        var retrofit: Retrofit? = null
        fun getretofit(): Retrofit?
        {
            if (retrofit == null)
            {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }


            return retrofit
        }



    }
}