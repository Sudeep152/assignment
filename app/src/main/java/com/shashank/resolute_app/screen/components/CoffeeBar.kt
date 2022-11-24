package com.shashank.resolute_app.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shashank.resolute_app.R

@Composable
fun CoffeeBar(
    painter: Painter, name: String, modifier: Modifier = Modifier,
    offer: String, price: String,
) {
    
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth().padding(5.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
        CoffeCard(painter = painter)
        CoffeNameOffer(name = name, offer =offer )
        PriceText(price = "59.66")
    }



}

@Composable
fun  CoffeNameOffer(name: String,offer: String){
    Column(modifier = Modifier
        .wrapContentWidth()
        ) {
        Text(text = name, style = TextStyle(color = Color(100, 112, 57), fontSize = 16.sp, fontWeight = FontWeight.SemiBold))
        Text(text = offer
               , style = TextStyle( color = Color(112, 112, 112),fontSize = 14.sp)
        )
    }
}

@Composable
fun  PriceText(price: String){

    Column(modifier = Modifier
        .wrapContentWidth()
        .padding(start = 60.dp, end = 10.dp)) {

            Image(painter = painterResource(id = R.drawable.price_ic), contentDescription = "price"
            )
        Text(text =price, style = TextStyle(color = Color(100, 112, 57), fontSize = 25.sp, fontWeight = FontWeight.SemiBold))

    }

}



@Composable
fun  CoffeCard(painter: Painter,modifier: Modifier=Modifier){

    Card(
        shape = RoundedCornerShape(10.dp)
        ,
        border = BorderStroke(7.dp, Brush.verticalGradient(listOf(
             Color(235, 255, 162),Color(172, 203, 57)
            )
        )

        )


    ) {
        Image(painter = painter, contentDescription ="Tea"
        , modifier = Modifier

                .width(70.dp)
                .height(70.dp)
                .padding(10.dp)
        )
    }

}
@Preview
@Composable
fun showCoffee(){

    CoffeeBar(painter = painterResource(id = R.drawable.tea1), name ="Bubble Tea" , offer ="Good Day Time" , price ="200" )
}