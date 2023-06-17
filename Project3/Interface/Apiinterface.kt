package com.example.project123.Interface

import com.example.finalproject_batch_1130.Model.RegisterModel
import com.example.project123.Model.ArtModel
import com.example.project123.Model.HomeModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Apiinterface
{
    @FormUrlEncoded
    @POST("signup.php")
    fun registerdata
    (
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("gender") gender:String?,
        @Field("email") email: String?,
        @Field("phone") mobile: String?,
        @Field("password") password: String?,
        ): Call<Void>


    @FormUrlEncoded
    @POST("login.php")
    fun logindata
    (
        @Field("phone") mobile: String?,
        @Field("pass") password: String?

    ): Call<RegisterModel>

    @GET("category.php")
    fun viewData(): Call<List<HomeModel>>

    @GET("art_1.php")
    fun art1view(): Call<List<ArtModel>>

    @GET("art_2.php")
    fun art2view(): Call<List<ArtModel>>




}