package com.shashank.resolute_app.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.shashank.resolute_app.R

@Composable
fun SingleLabelText(text: String, check: Boolean) {

    if (check) {
        Text(text = text,
            style = TextStyle(fontSize = 17.sp, color = Color(100, 112, 57)),
            fontWeight = FontWeight.SemiBold)
    } else {
        Text(
            text = text,
            style = TextStyle(fontSize = 17.sp, color = Color(71, 80, 90)),
        )
    }
}


@Composable
fun SingleTagWithDesgin(modifier: Modifier = Modifier, text: String, check: Boolean) {

    Column(modifier = modifier
        .wrapContentSize()
        .padding(end = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        SingleLabelText(text = text, check = check)
        if (check) {
            Icon(painter = painterResource(id = R.drawable.dot_ic),
                contentDescription = "dot",
                tint = Color(100, 112, 57))
        } else {
            Icon(painter = painterResource(id = R.drawable.dot_ic),
                contentDescription = "dot",
                tint = Color.White)

        }

    }

}


@Composable
fun SingleTeaBarTitle(painter: Painter, name: String, check: Boolean,click:()->Unit) {

Box(contentAlignment = Alignment.Center, modifier = Modifier.padding(10.dp)

    .clickable {
         click()
    }
){
    Card(modifier = Modifier
        .width(122.dp)
        .height(158.dp), backgroundColor = Color(235, 255, 162), shape = RoundedCornerShape(20.dp),
        elevation = 3.dp
    ) {

        if(check){
            Box() {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_bookmark_24),
                    contentDescription = "book", modifier = Modifier.padding(start = 5.dp)
                )

            }
        }

        Spacer(modifier = Modifier.heightIn(5.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.wrapContentSize()


        ) {

            Image(painter = painter, contentDescription = "image", modifier = Modifier.size(102.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = name,
                style = TextStyle(fontSize = 14.sp, color = Color(100, 112, 57)),
                fontWeight = FontWeight.SemiBold)


        }

    }

}




}

@Preview
@Composable
fun showBAr() {
    Column(modifier = Modifier.fillMaxSize()) {




    }

}