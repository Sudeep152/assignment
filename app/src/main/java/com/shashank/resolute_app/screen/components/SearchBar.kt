package com.shashank.resolute_app.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EdtTextField(hint: String) {


    Box(modifier = Modifier
        .padding(top = 25.dp, start = 20.dp, end = 20.dp)
        .fillMaxWidth()
        .wrapContentHeight()) {
        var textState by remember { mutableStateOf("") }
        val maxLength = 100
        val lightBlue = Color(235,235,235)
        TextField(
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription ="", tint =
                Color(106,106,109)
                , modifier = Modifier.size(30.dp)
                )

            },
            modifier = Modifier.fillMaxWidth().wrapContentHeight().clip(RoundedCornerShape(50.dp)),
            value = textState,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = lightBlue,
                textColor = Color(106,106,109),
                cursorColor = Color(0, 136, 248),
                disabledLabelColor = lightBlue,
                placeholderColor = Color(129, 129, 129),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                if (it.length <= maxLength) textState = it
            },
            placeholder = {
                Text(text = "$hint", fontSize = 18.sp,)
            },
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            trailingIcon = {
                if (textState.isNotEmpty()) {
                    IconButton(onClick = { textState = "" }) {
                        Icon(
                            imageVector = Icons.Outlined.Close,
                            contentDescription = null
                        )
                    }
                }
            }
        )
    }
}
