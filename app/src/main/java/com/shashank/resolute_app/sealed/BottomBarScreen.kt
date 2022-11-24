package com.shashank.resolute_app.sealed


import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

import com.shashank.resolute_app.R

sealed class BottomBarScreen(val route:String,val title:String ,val icon:Int){

       object Store:BottomBarScreen("store_screen","Store",  R.drawable.store_ic)
       object Home:BottomBarScreen("home_screen","Home",  R.drawable.home_ic)
       object Cart:BottomBarScreen("cart_screen","Cart",  R.drawable.cart_ic)
       object Profile:BottomBarScreen("profile_screen","profile",  R.drawable.cart_ic)
       object DetailScreen:BottomBarScreen("detail_screen","Detail",R.drawable.cart_ic)

}