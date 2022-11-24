package com.shashank.resolute_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.sharp.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.shashank.resolute_app.R
import com.shashank.resolute_app.screen.components.CoffeCard
import com.shashank.resolute_app.sealed.BottomBarScreen



@Composable
fun CartScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(listOf(Color.White, Color(235, 235, 235)))
        )

    ) {
        Row(modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {

            Column(modifier = Modifier
                .wrapContentWidth()
                .padding(start = 15.dp)) {
                SmallTopBar(navController = navController)
                Spacer(modifier = Modifier.height(40.dp))
                Column() {
                    Text(text = "Shopping Cart",
                        style = TextStyle(fontSize = 25.sp, color = Color(71, 80, 90)),
                        fontWeight = FontWeight.SemiBold, modifier = Modifier
                            .wrapContentSize()

                    )
                    Text(text = "3 items in Cart",
                        style = TextStyle(fontSize = 15.sp, color = Color(71, 80, 90)))

                }


            }


            Box(modifier = Modifier.wrapContentSize(), contentAlignment = Alignment.TopEnd) {

                Image(painter = painterResource(id = R.drawable.desgin),
                    contentDescription = "s",
                    modifier = Modifier
                        .size(200.dp)
                        .padding(bottom = 80.dp, start = 20.dp)
                )
            }

        }

        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize()) {
            SingleCartItem(painter = painterResource(id = R.drawable.tea1),
                name = "Bubble Tea",
                price = "56.88")
            SingleCartItem(painter = painterResource(id = R.drawable.tea2),
                name = "Purple Tea",
                price = "59.98")

            SingleCartItem(painter = painterResource(id = R.drawable.lemon),
                name = "Lemon Tea",
                price = "59.98")

        }
        Spacer(modifier = Modifier.height(80.dp))
        CustomButton()


    }


}


@Composable
fun SmallTopBar(navController: NavController) {


    TopAppBar(modifier = Modifier.width(50.dp), backgroundColor = Color.White, elevation = 0.dp) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(1.dp))
            Icon(painter = painterResource(id = R.drawable.list),
                contentDescription = "",
                modifier = Modifier.clickable {
                })
        }

    }


}


@Composable
fun SingleCartItem(
    painter: Painter, name: String, price: String,
) {

    Row(modifier = Modifier
        .padding(6.dp)
        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        CoffeCard(painter = painter)
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = name,
                style = TextStyle(fontSize = 20.sp, color = Color(71, 80, 90)),
                fontWeight = FontWeight.SemiBold, modifier = Modifier
                    .wrapContentSize()

            )
            Box {

                Image(painter = painterResource(id = R.drawable.price_ic),
                    contentDescription = "",
                    modifier = Modifier.size(10.dp))
                Spacer(modifier = Modifier.height(1.dp))
                Text(text = price,
                    style = TextStyle(fontSize = 15.sp, color = Color(100, 112, 57)),
                    fontWeight = FontWeight.SemiBold, modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 10.dp, start = 3.dp)

                )
            }
        }
        MyCounter()

    }
}


@Composable
fun MyCounter() {

    val counter = remember {
        mutableStateOf(1)
    }


    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = R.drawable.minus),
            contentDescription = "minus",
            modifier = Modifier
                .size(18.dp)
                .clickable {
                    counter.value--;
                }

        )

        Box(modifier = Modifier
            .wrapContentSize()
           , contentAlignment = Alignment.Center) {
            Text(text = "${counter.value}",
                style = TextStyle(fontSize = 18.sp, color = Color.Black),
                fontWeight = FontWeight.SemiBold, modifier = Modifier
                    .wrapContentSize()

            )
        }

        Image(painter = painterResource(id = R.drawable.plus),
            contentDescription = "minus",
            modifier = Modifier
                .size(18.dp)
                .clickable {
                    counter.value++
                }
        )

    }
}


@Composable
fun CustomButton(){


    Card(backgroundColor =Color(172, 203, 57)
    , shape = RoundedCornerShape(25.dp),
        modifier = Modifier.padding(20.dp, bottom = 30.dp, end = 20.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically) {

            CustomText(text = "Total", size = 15, bold =false )
            Box {

                Image(painter = painterResource(id = R.drawable.w_ic_price),
                    contentDescription = "",
                    modifier = Modifier.size(13.dp))
                Spacer(modifier = Modifier.height(1.dp))
                Text(text = "122.1",
                    style = TextStyle(fontSize = 18.sp, color = Color.White),
                    fontWeight = FontWeight.SemiBold, modifier = Modifier
                        .wrapContentSize()
                        .padding(top = 10.dp, start = 3.dp)

                )
            }
            CustomText(text = "Next", size =18 , bold =true )
            Icon(imageVector = Icons.Sharp.ArrowForward, contentDescription ="", tint = Color.White )
        }

    }


}



@Composable
fun CustomText(text:String,size :Int,bold:Boolean
){
    Text(text = text,
    style = TextStyle(color = Color.White, fontSize = size.sp)
, fontWeight =
        if (bold) {
           FontWeight.SemiBold
        }else{
            FontWeight.Normal
        }
        )
}
