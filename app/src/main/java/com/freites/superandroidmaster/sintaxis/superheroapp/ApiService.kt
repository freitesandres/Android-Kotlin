package com.freites.superandroidmaster.sintaxis.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/8764bb681ace0e80e1fef36d567b8160/search/{name}")
    suspend fun getSuperheroes(@Path("name") superheroName: String?): Response<SuperHeroDataResponse>
}