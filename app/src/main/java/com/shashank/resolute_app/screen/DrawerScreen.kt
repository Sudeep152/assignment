package com.shashank.resolute_app.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import  com.shashank.resolute_app.R

@Composable
fun DrawerScree() {

    Box {
        Pattern()
        Column(modifier = Modifier.fillMaxSize()) {

            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)) {
                ProfilePhoto()
                Box(contentAlignment = Alignment.CenterStart, modifier = Modifier
                    .size(100.dp)
                    .padding(3.dp)){
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                          MyText(string = "Jhon Tim", color =Color(100, 112, 57) , size = 15, fontWeight = FontWeight.SemiBold )
                          MyText(string = "Edit Profile", color =Color(100, 112, 57) , size = 10, fontWeight = FontWeight.SemiBold )
                    }
                }
            }
            Spacer(modifier = Modifier
                .height(2.dp)
                .width(200.dp)
                .background(Color.Black))
            
            Column() {
               DrwareMenu(string = "Categories ")
               DrwareMenu(string = "Your Orders ")
               DrwareMenu(string = "Wishlist ")
               DrwareMenu(string = "Categories ")
            }
            


        }
    }
}


@Composable
fun DrwareMenu(string: String){
    
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)){
        MyText(string = string, size =17 , color =Color.Black, fontWeight = FontWeight.SemiBold)

    }

}


@Composable
fun ProfilePhoto() {
    Card(shape = CircleShape, backgroundColor = Color.White) {
        Image(painter = painterResource(id = R.drawable.dp),
            contentDescription = "",
            modifier = Modifier.size(100.dp)
        )

    }
}

@Composable
fun Pattern() {
    Box(modifier = Modifier.fillMaxSize()

    ) {
        Image(painter = painterResource(id = R.drawable.bg_5), contentDescription = "")
    }


}

@Composable
fun MyText(string: String,color: Color,size:Int,modifier: Modifier=Modifier,fontWeight: FontWeight){
    
    Text(text = string, style = TextStyle(color=color, fontSize = size.sp,fontWeight))
    
}


@Preview
@Composable
fun SHowmE() {

    DrawerScree()

}