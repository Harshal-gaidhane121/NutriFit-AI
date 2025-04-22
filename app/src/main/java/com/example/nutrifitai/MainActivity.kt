package com.example.nutrifitai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nutrifitai.Screens.HomeScreen
import com.example.nutrifitai.Screens.SetProfileScreen
import com.example.nutrifitai.ui.theme.NutriFitAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NutriFitAITheme {
                NutriFitNavigation()
            }
        }
    }
}

@Composable
fun NutriFitNavigation() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.systemBars
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "set_profile",
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable("set_profile") {
                SetProfileScreen(
                    onGetStartedClick = { profileData ->
                        navController.navigate("home") {
                            popUpTo("set_profile") { inclusive = true }
                        }
                    }
                )
            }
            composable("home") {
                HomeScreen()
            }
        }
    }
}

