package com.nuom.nuomtest.data

import com.google.gson.JsonElement
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface for making API requests
 */
interface ApiInterface {
    @GET("random")
    suspend fun getPosts(): Response<JsonElement>

}