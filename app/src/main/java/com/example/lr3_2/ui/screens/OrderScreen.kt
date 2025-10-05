package com.example.lr3_2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lr3_2.model.FuelType
import com.example.lr3_2.viewmodel.FuelViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(viewModel: FuelViewModel, onFinish: () -> Unit) {
    var selectedFuel by remember { mutableStateOf(FuelType.AI92) }
    var litersInput by remember { mutableStateOf("") }

    val colorScheme = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Новый заказ", style = typography.titleLarge) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorScheme.primaryContainer,
                    titleContentColor = colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Завершение смены") },
                icon = { Icon(Icons.Default.Done, contentDescription = null) },
                onClick = onFinish,
                containerColor = colorScheme.primary,
                contentColor = colorScheme.onPrimary
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Выберите вид топлива", style = typography.titleMedium)

            var expanded by remember { mutableStateOf(false) }

            ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = it }) {
                OutlinedTextField(
                    value = selectedFuel.displayName,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Вид топлива") },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    modifier = Modifier
                        .menuAnchor(type = ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                        .fillMaxWidth(),
                    textStyle = typography.bodyLarge
                )

                ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                    FuelType.entries.forEach { fuel ->
                        DropdownMenuItem(
                            text = { Text(fuel.displayName, style = typography.bodyLarge) },
                            onClick = {
                                selectedFuel = fuel
                                expanded = false
                            }
                        )
                    }
                }
            }

            OutlinedTextField(
                value = litersInput,
                onValueChange = { litersInput = it },
                label = { Text("Количество литров") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                textStyle = typography.bodyLarge
            )

            Button(
                onClick = {
                    litersInput.toDoubleOrNull()?.let { liters ->
                        viewModel.addSale(selectedFuel, liters)
                        litersInput = ""
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorScheme.secondary,
                    contentColor = colorScheme.onSecondary
                )
            ) {
                Text("Добавить", style = typography.titleMedium)
            }
        }
    }
}