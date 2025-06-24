package com.example.tt_exchangerate.data.remote

import retrofit2.http.GET

interface CbrApi {
    @GET("daily_json.js")
    suspend fun getDailyRates(): CbrResponse
}