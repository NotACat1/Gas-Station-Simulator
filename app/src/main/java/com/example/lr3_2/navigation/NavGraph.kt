package com.example.lr3_2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lr3_2.ui.screens.OrderScreen
import com.example.lr3_2.ui.screens.SummaryScreen
import com.example.lr3_2.viewmodel.FuelViewModel

/**
 * Основной граф навигации приложения.
 *
 * Управляет переходами между двумя основными экранами:
 * - [OrderScreen] — ввод данных о новом заказе;
 * - [SummaryScreen] — отображение итогов смены.
 *
 * Использует [FuelViewModel] для совместного доступа к данным.
 *
 * @param navController Контроллер навигации Compose.
 * @param viewModel Общий экземпляр [FuelViewModel] для экранов.
 */
@Composable
fun NavGraph(navController: NavHostController, viewModel: FuelViewModel) {
    NavHost(navController, startDestination = "order") {

        // Экран оформления нового заказа
        composable("order") {
            OrderScreen(
                viewModel = viewModel,
                onFinish = { navController.navigate("summary") }
            )
        }

        // Экран итогов смены
        composable("summary") {
            SummaryScreen(
                viewModel = viewModel,
                onBack = {
                    navController.popBackStack("order", inclusive = false)
                }
            )
        }
    }
}
