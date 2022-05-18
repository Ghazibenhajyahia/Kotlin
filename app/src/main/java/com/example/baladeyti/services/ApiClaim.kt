package com.example.baladeyti.services

import com.example.baladeyti.models.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiClaim {

  /* if needed query params @Query("key") key: String*/
  @Multipart
    @POST("/claims/")
    fun createClaim(
       /* @Body claim: Claim,*/
        @PartMap data : LinkedHashMap<String, RequestBody>,
        @Part photos: MultipartBody.Part
    ):Call<Claim>



    @GET("claims")
    fun getClaims(): Call<Claim>

    @GET("claims/author/{id}")
    fun getClaimsByAuthor( @Path("id") id:String): Call<Claim>

    companion object {
        fun create(): ApiClaim {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://baladeyti-application.herokuapp.com")
                .build()
            return retrofit.create(ApiClaim::class.java)

        }
    }
/*    @POST("/users")
    fun createUser(@Body user: User): Response<CreateUserResponse>*/
}