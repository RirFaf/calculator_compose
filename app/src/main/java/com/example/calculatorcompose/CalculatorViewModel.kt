package com.example.calculatorcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

sealed interface CalculatorState {
    data class Main(
        val firstNumber: Double? = null,
        val operation: String = "",
        val secondNumber: Double? = null,
        val result: String = "",
        val input: String = ""
    )
}

class CalculatorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalculatorState.Main())
    val uiState: StateFlow<CalculatorState.Main> = _uiState.asStateFlow()

    fun getResult() {
        _uiState.update {
            it.copy(
                //так как у нас нулловые типы, мы проводим строгую проверку с помощью (!!)
                //так же оборачиваем в конструкцию try catch для лишней безпасности от вылетов
                result = try {
                    //данная конструкция позволяет проверять переменную и в зависимости от того, какое значение
                    //она примет, выполнится действие
                    when (it.operation) {
                        "+" -> {
                            (it.firstNumber!! + it.secondNumber!!).toString()
                        }

                        "-" -> {
                            (it.firstNumber!! - it.secondNumber!!).toString()
                        }

                        "*" -> {
                            (it.firstNumber!! * it.secondNumber!!).toString()
                        }

                        "/" -> {
                            (it.firstNumber!! / it.secondNumber!!).toString()
                        }

                        else -> {
                            "error"
                        }
                    }
                } catch (e: Exception) {
                    "error"
                }
            )
        }
    }

    fun setInput(input: String) {
        _uiState.update {
            it.copy(
                input = input
            )
        }
    }

    fun clearAll() {
        _uiState.update {
            it.copy(
                firstNumber = null,
                operation = "",
                secondNumber = null,
                result = "",
                input = ""
            )
        }
    }

    fun clearLast() {
        _uiState.update {
            if (it.result != "") {
                it.copy(
                    result = ""
                )
            } else if (it.secondNumber != null) {
                it.copy(
                    input = "",
                    secondNumber = null
                )
            } else if (it.operation != "") {
                it.copy(
                    operation = ""
                )
            } else {
                it.copy(
                    input = "",
                    firstNumber = null
                )
            }
        }
    }

    fun setFirstNum() {
        if (_uiState.value.result == "" || _uiState.value.input.isNotBlank()) {
            _uiState.update {
                it.copy(
                    firstNumber = it.input.toDouble()
                )
            }
            _uiState.update {
                it.copy(
                    secondNumber = null,
                    result = "",
                    input = ""
                )
            }
        } else {
            _uiState.update {
                it.copy(
                    firstNumber = it.result.toDouble(),
                    operation = "",
                    secondNumber = null,
                    result = "",
                    input = ""
                )
            }
        }
    }

    fun setSecondNum() {
        _uiState.update {
            it.copy(
                secondNumber = it.input.toDouble()
            )
        }
        _uiState.update {
            it.copy(
                input = ""
            )
        }
    }

    fun setOperation(input: String) {
        _uiState.update {
            it.copy(
                operation = input
            )
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                CalculatorViewModel()
            }
        }
    }
}