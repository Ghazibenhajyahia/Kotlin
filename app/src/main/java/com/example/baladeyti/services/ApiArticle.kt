package com.example.baladeyti.services

import com.example.baladeyti.models.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiArticle {

  /* if needed query params @Query("key") key: String*/



    @GET("articles")
    fun getArticles(): Call<Article>



    companion object {
        fun create(): ApiArticle {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://baladeyti-application.herokuapp.com")
                .build()
            return retrofit.create(ApiArticle::class.java)

        }
    }
/*    @POST("/users")
    fun createUser(@Body user: User): Response<CreateUserResponse>*/
}