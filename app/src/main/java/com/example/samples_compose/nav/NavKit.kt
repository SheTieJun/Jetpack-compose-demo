package com.example.samples_compose.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun getNavController(): NavHostController {
    return rememberNavController()
}