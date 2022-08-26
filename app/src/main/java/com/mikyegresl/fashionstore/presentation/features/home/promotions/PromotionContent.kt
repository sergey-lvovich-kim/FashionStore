package com.mikyegresl.fashionstore.presentation.features.home.promotions

import android.text.Spannable
import android.text.SpannableString
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikyegresl.fashionstore.domain.promotions.Promotion
import com.mikyegresl.fashionstore.presentation.ui.extensions.fromHtml

@Composable
fun PromotionContent(
    promotion: Promotion
) {
    val backgroundColor = remember { mutableStateOf(Color(android.graphics.Color.parseColor(promotion.backgroundColor))) }
    val textColor = remember { mutableStateOf(Color(android.graphics.Color.parseColor(promotion.textColor))) }
    val promotionText = remember { mutableStateOf<Spannable>(SpannableString.valueOf(promotion.content.fromHtml())) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor.value)
            .padding(16.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = promotionText.value.toString(),
            color = textColor.value,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )
    }
}