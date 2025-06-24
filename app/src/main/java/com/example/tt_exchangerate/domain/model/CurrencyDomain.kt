package com.example.tt_exchangerate.domain

data class CurrencyDomain(
    val abbreviationName: String,
    val decryptionName: String,
    val courseNow: Double,
    val courseLast: Double
)