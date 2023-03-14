package com.loanapp.app.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loanapp.app.LoanData
import com.loanapp.app.api.LoanApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoanViewModel : ViewModel() {

    val loanDataList = mutableStateListOf<LoanData>()

    init {
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch(Dispatchers.Main) {
            loanDataList.addAll(LoanApi.getLoanData())
        }
    }

}