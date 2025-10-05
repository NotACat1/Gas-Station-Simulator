package com.example.lr3_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.lr3_2.navigation.NavGraph
import com.example.lr3_2.viewmodel.FuelViewModel
import com.example.lr3_2.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                val viewModel: FuelViewModel = viewModel()
                NavGraph(navController, viewModel)
            }
        }
    }
}