package ro.alingrosu.aviv.presentation.navigation

sealed class Screen(val route: String) {
    object Listings : Screen("listings")
    object ListingDetail : Screen("listing/{id}") {
        fun createRoute(id: Int) = "listing/$id"
    }
}