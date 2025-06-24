package com.example.tt_exchangerate.domain

interface CurrencyRepository {
    suspend fun getCurrencies(): List<CurrencyDomain>
}