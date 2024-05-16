package com.example.calculatorcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel
) {
    val state by viewModel.uiState.collectAsState()
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = state.input,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = state.firstNumber.toString(),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = state.operation,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = state.secondNumber.toString(),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = state.result.toString(),
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {
                //такая конструкция позволяет выполнить блок кода и сразу вставить его в строку
                //в данном случае мы взяли существующее значение ввода и приписали к нему 1
                viewModel.setInput("${state.input}1")
            }) {
                Text(text = "1")
            }
            Button(onClick = {
                viewModel.setInput("${state.input}2")
            }) {
                Text(text = "2")
            }
            Button(onClick = {
                viewModel.setInput("${state.input}3")
            }) {
                Text(text = "3")
            }
            Button(
                onClick = {
                    if (state.firstNumber == null) {
                        viewModel.setFirstNum()
                        viewModel.setOperation("+")
                    } else {
                        viewModel.setSecondNum()
                        viewModel.getResult()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text(text = "+")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {
                viewModel.setInput("${state.input}4")
            }) {
                Text(text = "4")
            }
            Button(onClick = {
                viewModel.setInput("${state.input}5")
            }) {
                Text(text = "5")
            }
            Button(onClick = {
                viewModel.setInput("${state.input}6")
            }) {
                Text(text = "6")
            }
            Button(
                onClick = {
                    if (state.firstNumber == null) {
                        viewModel.setFirstNum()
                        viewModel.setOperation("-")
                    } else {
                        viewModel.setSecondNum()
                        viewModel.getResult()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text(text = "-")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {
                viewModel.setInput("${state.input}7")
            }) {
                Text(text = "7")
            }
            Button(onClick = {
                viewModel.setInput("${state.input}8")
            }) {
                Text(text = "8")
            }
            Button(onClick = {
                viewModel.setInput("${state.input}9")
            }) {
                Text(text = "9")
            }
            Button(
                onClick = {
                    if (state.firstNumber == null) {
                        viewModel.setFirstNum()
                        viewModel.setOperation("*")
                    } else {
                        viewModel.setSecondNum()
                        viewModel.getResult()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text(text = "*")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    viewModel.clearAll()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "CE")
            }
            Button(onClick = {
                viewModel.setInput("${state.input}0")
            }) {
                Text(text = "0")
            }
            Button(onClick = {
                if (state.input.last() != '.') {
                    viewModel.setInput("${state.input}.")
                }
            }) {
                Text(text = ".")
            }
            Button(
                onClick = {
                    if (state.firstNumber == null) {
                        viewModel.setFirstNum()
                        viewModel.setOperation("/")
                    } else {
                        viewModel.setSecondNum()
                        viewModel.getResult()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text(text = "/")
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    viewModel.clearLast()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Yellow,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "C")
            }
            Button(
                onClick = {
                    viewModel.setSecondNum()
                    viewModel.getResult()
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text(text = "=")
            }
        }
    }
}