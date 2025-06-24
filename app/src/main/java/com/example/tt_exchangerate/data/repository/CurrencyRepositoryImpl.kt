package com.example.tt_exchangerate.data.repository

import com.example.tt_exchangerate.data.remote.CbrApi
import com.example.tt_exchangerate.domain.model.CurrencyDomain
import com.example.tt_exchangerate.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val api: CbrApi
) : CurrencyRepository {


}