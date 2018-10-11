package com.decoled.codering.githubkotlin.Api

import com.decoled.codering.githubkotlin.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GithubApiService {
    fun create(): GithubApi {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val service = retrofit.create(GithubApi::class.java)
        return service
    }

}