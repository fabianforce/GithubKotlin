package com.decoled.codering.githubkotlin.Api

import com.decoled.codering.githubkotlin.User
import retrofit2.Call
import retrofit2.Response
import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface GithubApi {

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("login/oauth/access_token")
    fun login(@Field("client_id") client_id: String,
              @Field("client_secret") client_secret: String,
              @Field("code") code: String): Call<ResponseBody>
}
