package com.veprek.honza.homework.core.system

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.veprek.honza.homework.core.model.Screen
import com.veprek.honza.homework.design.ui.theme.HomeworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeworkTheme {
                val navController = rememberNavController()

                Navigation(
                    startDestination = Screen.AccountsList,
                    navController = navController,
                )
            }
        }
    }
}
