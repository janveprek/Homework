package com.veprek.honza.homework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.veprek.honza.homework.account.ui.TransparentAccountsScreen
import com.veprek.honza.homework.ui.theme.HomeworkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HomeworkTheme {
                TransparentAccountsScreen()
            }
        }
    }
}
