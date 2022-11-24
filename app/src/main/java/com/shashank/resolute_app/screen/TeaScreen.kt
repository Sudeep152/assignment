package com.shashank.resolute_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import  com.shashank.resolute_app.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun TeaScreen() {

    Box(contentAlignment = Alignment.TopEnd) {

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(215, 239, 122))) {
            BottomDetails()
        }
        Row(horizontalArrangement = Arrangement.SpaceAround) {
            UpperDesign(name = "", event = "", price = "")
            Box(modifier = Modifier
                .wrapContentSize()
                .padding(top = 80.dp, start = 1.dp)) {
                Image(painter = painterResource(id = R.drawable.ice_tea),
                    contentDescription = "",
                    modifier = Modifier.size(250.dp)
                )
            }
        }


    }


}

@Composable
fun DetailScreen() {

    Box {

        TeaScreen()

    }

}


@Composable
fun BottomDetails() {


    Box(Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp))
        .size(450.dp)
        .background(Color(172, 203, 57))) {

        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(25.dp)) {

            NameText(name = "Particulars", size = 33, color = Color(100, 112, 57))
            Box(Modifier
                .wrapContentSize()
                .padding(5.dp)) {
                Text(text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,",
                    style = TextStyle(color = Color(100, 112, 57), fontSize = 15.sp))
            }
            starSction()
            AllIngredients()
            Column(Modifier.wrapContentSize()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter){
                    ButtomBar()
                }

            }

        }
    }


}


@Composable
fun UpperDesign(name: String, event: String, price: String) {

    Box(modifier = Modifier
        .wrapContentSize()
        .padding(top = 80.dp, start = 20.dp)) {
        Column() {
            NameText(name = "Lemon Tea", 28, Color(100, 112, 57))
            NameText(name = "Good day time", 16, Color(112, 112, 112))
            PriceBox(price = "14.56")
        }

    }

}


@Composable
fun PriceBox(price: String) {

    Column() {
        Image(painter = painterResource(id = R.drawable.price_ic),
            contentDescription = "price",
            modifier = Modifier.size(25.dp))
        NameText(name = price, size = 50, color = Color(100, 112, 57))
    }
}


@Composable
fun NameText(name: String, size: Int, color: Color) {

    Text(text = name,
        style = TextStyle(color = color, fontSize = size.sp, fontWeight = FontWeight.SemiBold))

}

@Composable
fun starSction(){
    Row(modifier = Modifier.fillMaxWidth()) {
        star()
        star()
        star()
        star()
        star()
    }
}

@Composable
fun star() {

    Image(painter = painterResource(id = R.drawable.star),
        contentDescription = "star",
        modifier = Modifier
            .size(30.dp)
            .padding(5.dp)
    )
}



@Composable
fun AllIngredients(){

    Row(modifier = Modifier.fillMaxWidth()) {
        SingleIngredient(painter = painterResource(id = R.drawable.water_pic), name ="Water")
        SingleIngredient(painter = painterResource(id = R.drawable.ice_pic), name ="Ice")
        SingleIngredient(painter = painterResource(id = R.drawable.sugar_pic), name ="Sugar")
    }

}


@Composable
fun  SingleIngredient(painter: Painter,name: String){
   
    Card(backgroundColor =Color(235, 255, 162)
    , shape = RoundedCornerShape(10.dp)
    , modifier = Modifier.padding(4.dp)
    ) {
        Box(modifier = Modifier
            .size(70.dp)
            .padding(4.dp), contentAlignment = Alignment.Center){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painter, contentDescription ="" , modifier = Modifier.size(45.dp))
                Text(text = name, style = TextStyle(color = Color(100, 112, 57 ), fontSize = 15.sp, fontWeight = FontWeight.SemiBold))
            }

        }
    }

}



@Composable
fun ButtomBar(){
        
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
        Icon(painter = painterResource(id = R.drawable.vec_back), contentDescription = "time" , modifier = Modifier.size(20.dp))
        Icon(painter = painterResource(id = R.drawable.like_ic), contentDescription = "time", modifier = Modifier.size(20.dp) )
        Card(backgroundColor =Color(172, 203, 57)

        , shape = RoundedCornerShape(20.dp)
        ) {
            Box(modifier = Modifier
                .width(150.dp)
            , contentAlignment = Alignment.Center
            ) {
                Text(text = "Purchase",
                    style = TextStyle(fontSize = 18.sp, color = Color.White),
                    fontWeight = FontWeight.SemiBold, modifier = Modifier
                        .wrapContentSize()
                        .padding(10.dp)

                )
            }
        }
    }

}

@Preview
@Composable
fun SHOw() {
    DetailScreen()
}