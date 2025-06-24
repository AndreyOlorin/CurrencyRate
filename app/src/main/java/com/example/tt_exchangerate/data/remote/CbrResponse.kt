package com.example.tt_exchangerate.data.remote

data class CbrResponse(
    val Valute: Map<String, ValuteItem>
)

data class ValuteItem(
    val CharCode: String,
    val Name: String,
    val Value: Double,
    val Previous: Double
)