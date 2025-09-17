package ro.alingrosu.aviv.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ro.alingrosu.aviv.presentation.ui.screens.detail.RealEstateDetailScreen
import ro.alingrosu.aviv.presentation.ui.screens.listing.RealEstateListScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Listings.route) {

        composable(Screen.Listings.route) {
            RealEstateListScreen(onItemClick = { id ->
                navController.navigate(Screen.ListingDetail.createRoute(id))
            })
        }

        composable(
            Screen.ListingDetail.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: return@composable
            RealEstateDetailScreen(realEstateId = id)
        }
    }
}