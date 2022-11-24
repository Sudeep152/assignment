package com.shashank.resolute_app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.shashank.resolute_app.R
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shashank.resolute_app.screen.components.CoffeeBar
import com.shashank.resolute_app.screen.components.EdtTextField
import com.shashank.resolute_app.screen.components.SingleTagWithDesgin
import com.shashank.resolute_app.screen.components.SingleTeaBarTitle
import com.shashank.resolute_app.sealed.BottomBarScreen


@Composable
fun HomeScreen(navController: NavController) {

    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
         CustomTOPBAR(navController = navController)
        }

    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .scrollable(state = scrollState, orientation = Orientation.Horizontal)
            .background(
                Brush.verticalGradient(listOf(Color.White, Color(235, 235, 235))))
        , contentAlignment =Alignment.TopCenter
        ) {


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                EdtTextField(hint = "Search")
                Spacer(modifier = Modifier.height(25.dp))
                LabelTextType()
                Spacer(modifier = Modifier.height(10.dp))
                TeaImageWithText(navController)
                Spacer(modifier = Modifier.heightIn(10.dp))
                viewPaigerBar()
                Spacer(modifier = Modifier.height(20.dp))
                SimpleWillText()
                Spacer(modifier = Modifier.height(10.dp))
                WillBuyColumn()


            }

        }

    }





}

@Composable
fun LabelTextType(){
    
   Row(modifier = Modifier
       .fillMaxWidth()
       .padding(start = 8.dp, end = 8.dp),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){

        SingleTagWithDesgin(text = "Recommendation", check = true)
        SingleTagWithDesgin(text = "Black Tea", check = false)
        SingleTagWithDesgin(text = "Sugar Tea", check = false)


   }

}



@Composable
fun TeaImageWithText(navController: NavController){

    Column(modifier = Modifier
        .wrapContentSize()
    ) {
        LazyRow(){ item {
            SingleTeaBarTitle(painter = painterResource(id = R.drawable.lemon),
                name = "Lemon Tea",
                check = true,){ nav(navController) }

            SingleTeaBarTitle(painter = painterResource(id = R.drawable.black),
                name = "Green Tea",
                check = false) { nav(navController) }
            SingleTeaBarTitle(painter = painterResource(id = R.drawable.black),
                name = "Black Tea",
                check = false) { nav(navController) }


        }


        }
    }


}

fun nav(navController: NavController){
    navController.navigate(BottomBarScreen.DetailScreen.route)
}





@Composable
fun  CustomTOPBAR(navController: NavController,){

    TopAppBar(backgroundColor = Color.White, elevation = 0.dp) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(20.dp))
            Icon(painter = painterResource(id = R.drawable.list), contentDescription ="", modifier = Modifier.clickable {



                navController.navigate(BottomBarScreen.Profile.route)
            } )
            Spacer(modifier = Modifier.width(15.dp))
            Text(text = "Hi, Jhon!", style =  TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold))
        }

    }
}


@Composable
fun SimpleWillText(){
   Column(modifier = Modifier.fillMaxWidth()

   ) {
       Text(text = "Will Buy", style = TextStyle(
           color = Color.Black,
           fontSize = 15.sp,
           fontWeight = FontWeight.SemiBold
       ), modifier = Modifier.padding(start = 25.dp)
       )
   }
}



@Composable
fun WillBuyColumn(){

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {

            CoffeeBar(painter = painterResource(id = R.drawable.tea1), name ="Bubble Tea" , offer ="Good Time" , price ="56.11" )
            CoffeeBar(painter = painterResource(id = R.drawable.tea2), name ="Purple Tea" , offer ="Good Time" , price ="56.11" )
        }
    }

}






@Composable
fun viewPaigerBar(){


    Row(modifier = Modifier.padding(start = 25.dp, end = 25.dp)) {

        Card(
            elevation = 0.dp
            ,
            shape = RoundedCornerShape(20.dp)
            ,
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
            , backgroundColor = Color(235, 235, 235)
        ){
            Row() {
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(8.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(215, 239, 127))
                ){

                }
            }


        }
    }

    
}