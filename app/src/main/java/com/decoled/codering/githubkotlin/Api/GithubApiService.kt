package com.decoled.codering.githubkotlin.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubApiService {
    val URL = "https://api.github.com/"
    fun create(): GithubApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(GithubApi::class.java)
        return service
    }

}