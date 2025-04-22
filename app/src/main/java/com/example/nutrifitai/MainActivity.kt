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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.nutrifitai.Screens.SetProfileScreen
import com.example.nutrifitai.data.NutriFitDatabase
import com.example.nutrifitai.data.ProfileRepository
import com.example.nutrifitai.ui.ProfileViewModel
import com.example.nutrifitai.ui.ProfileViewModelFactory
import com.example.nutrifitai.ui.theme.NutriFitAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Initialize Room database
        val database = Room.databaseBuilder(
            applicationContext,
            NutriFitDatabase::class.java,
            "nutrifit_database"
        ).build()

        // Initialize repository
        val repository = ProfileRepository(database.profileDao())

        setContent {
            NutriFitAITheme {
                NutriFitNavigation(repository)
            }
        }
    }
}

@Composable
fun NutriFitNavigation(repository: ProfileRepository) {
    val navController = rememberNavController()
    val viewModel: ProfileViewModel = viewModel(factory = ProfileViewModelFactory(repository))

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
                    viewModel = viewModel,
                    onGetStartedClick = {
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

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to NutriFit AI!",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

