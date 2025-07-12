package com.example.tt_exchangerate.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tt_exchangerate.domain.model.CurrencyDomain
import com.example.tt_exchangerate.domain.usecase.GetCurrenciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getCurrenciesUseCase: GetCurrenciesUseCase) : ViewModel() {

    private val _currencies = MutableStateFlow<List<CurrencyDomain>>(emptyList())
    val currencies: StateFlow<List<CurrencyDomain>> = _currencies

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        loadCurrencies()
    }

    private fun loadCurrencies() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _currencies.value = getCurrenciesUseCase()
            }
            catch (e: Exception) {
            }
            finally {
                _isLoading.value = false
            }
        }
    }
}