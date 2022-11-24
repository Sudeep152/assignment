package com.shashank.resolute_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.shashank.resolute_app.screen.*
import com.shashank.resolute_app.sealed.BottomBarScreen


@Composable
fun  Bottom_NavGraph(navHostController : NavHostController){

     NavHost(navController = navHostController, startDestination = BottomBarScreen.Home.route ){
         composable(BottomBarScreen.Store.route){
                    StoreScreen()
         }
         composable(BottomBarScreen.Home.route){
             HomeScreen(navHostController)
         }
         composable(BottomBarScreen.Cart.route){
              CartScreen(navController = navHostController)
         }
         composable(route = BottomBarScreen.Profile.route){
            DrawerScree()
         }
         composable(route = BottomBarScreen.DetailScreen.route){
             DetailScreen()
         }
     }




}