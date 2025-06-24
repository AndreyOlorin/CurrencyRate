package com.example.tt_exchangerate.domain.repository

interface CurrencyRepository {
    suspend fun getCurrencies(): List<CurrencyDomain>
}