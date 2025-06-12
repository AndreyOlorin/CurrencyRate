package com.example.tt_exchangerate.data.model

data class Currency(
    val abbreviationName: String,
    val decryptionName: String,
    val courseNow: Double,
    val courseLast: Double
)