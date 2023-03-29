package com.laros.testpkdx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.laros.testpkdx.pokemonlist.PokeListScreen
import com.laros.testpkdx.pokemonlist.PokeListViewModel
import com.laros.testpkdx.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: PokeListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "poke_list_screen",
                ) {
                    composable("poke_list_screen") {
                        PokeListScreen(navController = navController)
                    }
                    composable(
                        "poke_detail_screen/ {dominantColor}/ {pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("pokemonName") {
                                type = NavType.StringType
                            },
                        ),
                    ) {
                        val dominantColor = remember {
                            {
                                val color = it.arguments?.getInt("dominantColor")
                                color?.let { Color(it) ?: Color.White }
                            }
                        }
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")
                        }
                    }
                }
            }
        }
    }
}
