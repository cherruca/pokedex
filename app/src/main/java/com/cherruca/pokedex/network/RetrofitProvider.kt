package com.cherruca.pokedex.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val retrofit: Retrofit by lazy {
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()
}