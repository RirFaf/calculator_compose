package com.example.calculatorcompose

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel,
    state: CalculatorState.Main
) {
    val configuration = LocalConfiguration.current
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = state.input,
            modifier = Modifier.fillMaxWidth(),
            style = when (configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> {
                    AppTypography.displayMedium
                }

                else -> {
                    AppTypography.bodyMedium
                }
            }
        )
        Text(
            text = if (state.firstNumber != null) {
                state.firstNumber.toString()
            } else {
                ""
            },
            modifier = Modifier.fillMaxWidth(),
            style = when (configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> {
                    AppTypography.displaySmall
                }

                else -> {
                    AppTypography.bodySmall
                }
            }
        )
        Text(
            text = state.operation,
            modifier = Modifier.fillMaxWidth(),
            style = when (configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> {
                    AppTypography.displaySmall
                }

                else -> {
                    AppTypography.bodySmall
                }
            }
        )
        Text(
            text = if (state.secondNumber != null) {
                state.secondNumber.toString()
            } else {
                ""
            },
            modifier = Modifier.fillMaxWidth(),
            style = when (configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> {
                    AppTypography.displaySmall
                }

                else -> {
                    AppTypography.bodySmall
                }
            }
        )
        Text(
            text = state.result.toString(),
            modifier = Modifier.fillMaxWidth(),
            style = when (configuration.orientation) {
                Configuration.ORIENTATION_PORTRAIT -> {
                    AppTypography.displayMedium
                }

                else -> {
                    AppTypography.bodyMedium
                }
            }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    //такая конструкция позволяет выполнить блок кода и сразу вставить его в строку
                    //в данном случае мы взяли существующее значение ввода и приписали к нему 1
                    viewModel.setInput("${state.input}1")
                },
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "1",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    viewModel.setInput("${state.input}2")
                },
                modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "2",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    viewModel.setInput("${state.input}3")
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "3",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    if (state.firstNumber == null || state.result != "") {
                        viewModel.setFirstNum()
                        viewModel.setOperation("+")
                    } else {
                        viewModel.setSecondNum()
                        viewModel.getResult()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "+",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    viewModel.setInput("${state.input}4")
                },
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "4",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    viewModel.setInput("${state.input}5")
                },
                modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "5",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    viewModel.setInput("${state.input}6")
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "6",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    if (state.firstNumber == null || state.result != "") {
                        viewModel.setFirstNum()
                        viewModel.setOperation("-")
                    } else {
                        viewModel.setSecondNum()
                        viewModel.getResult()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "-",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    viewModel.setInput("${state.input}7")
                },
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "7",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    viewModel.setInput("${state.input}8")
                },
                modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "8",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    viewModel.setInput("${state.input}9")
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "9",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    if (state.firstNumber == null || state.result != "") {
                        viewModel.setFirstNum()
                        viewModel.setOperation("*")
                    } else {
                        viewModel.setSecondNum()
                        viewModel.getResult()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "*",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
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
                ),
                modifier = Modifier
                    .fillMaxWidth(0.25f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "C",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    viewModel.setInput("${state.input}0")
                },
                modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "0",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    if (state.input.last() != '.') {
                        viewModel.setInput("${state.input}.")
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = ".",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    if (state.firstNumber == null || state.result != "") {
                        viewModel.setFirstNum()
                        viewModel.setOperation("/")
                    } else {
                        viewModel.setSecondNum()
                        viewModel.getResult()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "/",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
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
                ),
                modifier = Modifier
                    .fillMaxWidth(0.33f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "CE",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    viewModel.setSecondNum()
                    viewModel.getResult()
                },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "=",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
            Button(
                onClick = {
                    if (state.input.isNotEmpty()) {
                        viewModel.setInput(state.input.substring(0, state.input.lastIndex))
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp)
            ) {
                Text(
                    text = "<-",
                    style = when (configuration.orientation) {
                        Configuration.ORIENTATION_PORTRAIT -> {
                            AppTypography.displayLarge
                        }

                        else -> {
                            AppTypography.bodyLarge
                        }
                    }
                )
            }
        }
    }
}