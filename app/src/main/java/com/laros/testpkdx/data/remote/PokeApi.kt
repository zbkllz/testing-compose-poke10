package com.laros.testpkdx.data.remote

import com.laros.testpkdx.data.remote.responses.Pokemon
import com.laros.testpkdx.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeApi {
    @GET("pokemon")
    suspend fun getPokeList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokeInfo(
        @Path("name") name: String
    ): Pokemon
}