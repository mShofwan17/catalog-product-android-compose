package me.test.catalog_product.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.test.catalog_product.screens.detailProduct.DetailProductScreen
import me.test.catalog_product.screens.home.HomeScreen
import me.test.catalog_product.screens.search.SearchScreen
import me.test.domain.utils.UiConstant.ArgumentConst.ID_ARG

@Composable
fun SetupNavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screens.Home.route) {
        composable(route = Screens.Home.route) {
            HomeScreen(navHostController = navHostController)
        }
        composable(route = Screens.Search.route) {
            SearchScreen(navHostController = navHostController)
        }
        composable(
            route = Screens.DetailProduct.route,
            arguments = listOf(
                navArgument(name = ID_ARG){type = NavType.LongType}
            )
        ) {
            DetailProductScreen(navHostController = navHostController)
        }
    }
}