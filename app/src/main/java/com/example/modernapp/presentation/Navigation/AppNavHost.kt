package com.example.modernapp.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.modernapp.presentation.Adress.AdressScreen
import com.example.modernapp.presentation.Adress.AdressView
import com.example.modernapp.presentation.Uses.MainScreen
import com.example.modernapp.presentation.Uses.MainViewModel

@Composable
fun AppNavHost(
    navHostController: NavHostController = rememberNavController()
){
    NavHost(navController = navHostController, startDestination ="userScreen"  ){
        composable("userScreen") {
           val viewMainModel :MainViewModel = hiltViewModel()
            MainScreen(viewMainModel,onNavigateToAddress = {navHostController.navigate("addressScreen")})
        }
        composable("addressScreen") {
           val viewAdressView: AdressView = hiltViewModel()
           AdressScreen(viewAdressView, onBack = {navHostController.popBackStack()})
        }
    }
}