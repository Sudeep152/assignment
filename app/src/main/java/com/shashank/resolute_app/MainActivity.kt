package com.shashank.resolute_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.shashank.resolute_app.navigation.Bottom_NavGraph
import com.shashank.resolute_app.sealed.BottomBarScreen
import com.shashank.resolute_app.sealed.BottomBarScreen.Cart.icon
import com.shashank.resolute_app.ui.theme.Resolute_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MainScreenView()
        }
    }
}


@Composable
fun MainScreenView(){
    val navController = rememberNavController()
    Scaffold(
        backgroundColor = Color(251,251,251),
        bottomBar = { BttmNavigation(navController = navController) }
    ) {

        Bottom_NavGraph(navHostController = navController)
    }
}


@Composable
fun BttmNavigation(navController: NavController) {
    val items = listOf(

        BottomBarScreen.Store,
        BottomBarScreen.Home,
        BottomBarScreen.Cart

    )

    Box(modifier = Modifier.wrapContentSize().padding(bottom = 30.dp, start = 30.dp, end = 30.dp)){
        BottomNavigation(

            backgroundColor = Color.White
            , modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(25.dp, 25.dp, 25.dp,25.dp)),

        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.forEach { item ->

                BottomNavigationItem(
                    icon = {
                        if (item.route ==currentRoute){
                            Box( contentAlignment = Alignment.Center,modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .clip(
                                    CircleShape)
                                .background(Color(167, 207, 23)) ){
                                Icon(painterResource(id = item.icon), contentDescription = item.title) }
                        }else{
                            Icon(painterResource(id = item.icon), contentDescription = item.title)
                        }



                    },

                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.Black.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                )

            }


        }
    }


}