package com.mikyegresl.fashionstore.presentation.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikyegresl.fashionstore.R

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp),
            text = stringResource(id = R.string.app_web_url).uppercase(),
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            maxLines = 1,
        )
    }
}