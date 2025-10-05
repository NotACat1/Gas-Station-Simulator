package com.example.lr3_2.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lr3_2.viewmodel.FuelViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SummaryScreen(viewModel: FuelViewModel, onBack: () -> Unit) {
    val sales = viewModel.getSales()
    val total = viewModel.getTotalRevenue()

    val colorScheme = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Итоги смены", style = typography.titleLarge) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorScheme.primaryContainer,
                    titleContentColor = colorScheme.onPrimaryContainer
                )
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Новый заказ") },
                icon = { Icon(Icons.Default.Refresh, contentDescription = null) },
                onClick = {
                    viewModel.clearSales()
                    onBack()
                },
                containerColor = colorScheme.primary,
                contentColor = colorScheme.onPrimary
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (sales.isEmpty()) {
                Text("Нет данных за смену", style = typography.bodyLarge)
            } else {
                sales.forEach { (fuel, liters) ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainerHigh)
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            Text(fuel.displayName, style = typography.titleMedium)
                            Spacer(Modifier.height(4.dp))
                            Text(
                                "Продано: %.2f л".format(liters),
                                style = typography.bodyLarge
                            )
                            Text(
                                "Выручка: %.2f ₽".format(liters * fuel.pricePerLiter),
                                style = typography.bodyLarge
                            )
                        }
                    }
                }

                HorizontalDivider(Modifier.padding(vertical = 8.dp))

                Text(
                    "Общая выручка: %.2f ₽".format(total),
                    style = typography.headlineSmall,
                    color = colorScheme.primary
                )
            }
        }
    }
}