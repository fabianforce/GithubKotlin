package com.decoled.codering.githubkotlin.Api

import com.decoled.codering.githubkotlin.User
import retrofit2.Call
import retrofit2.Response
import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface GithubApi {

    @FormUrlEncoded
    @POST("user")
    fun login(@Field("Authorization") email: String, @Field("password") password: String): Call<ResponseBody>
}
