package com.example.tt_exchangerate.domain.usecase

import com.example.tt_exchangerate.domain.model.CurrencyDomain
import com.example.tt_exchangerate.domain.repository.CurrencyRepository
import javax.inject.Inject

class GetCurrenciesUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {
    suspend operator fun invoke(): List<CurrencyDomain> {
        return repository.getCurrencies()
    }
}