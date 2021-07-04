package com.castledrv.multitype_compose.ui.showcase

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.castledrv.multitype_compose.model.ProductBean
import com.google.accompanist.glide.rememberGlidePainter


@ExperimentalUnitApi
@ExperimentalComposeApi
@Composable
fun ProductItem(product: ProductBean, isDarkMode:Boolean,addBtnClick: (index: Int) -> Unit) {

    Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
        Image(
            painter = rememberGlidePainter(product.url),
            contentDescription = "product image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .size(108.dp, 108.dp)
                .clip(RoundedCornerShape(2.dp)),
        )
        Column(
            modifier = Modifier
                .padding(start = 12.dp)
                .requiredHeight(108.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = product.name,
                fontSize = TextUnit(15f, TextUnitType.Sp),
                fontWeight = FontWeight(500),
                maxLines = 2
            )
            Text(
                text = product.price,
                fontWeight = FontWeight(600),
                fontSize = TextUnit(15f, TextUnitType.Sp),
                modifier = Modifier.padding(top = 4.dp)
            )
            Text(
                text = product.origin,
                fontWeight = FontWeight(300),
                fontSize = TextUnit(13f, TextUnitType.Sp),
                modifier = Modifier.padding(top = 4.dp)
            )
            Spacer(modifier = Modifier.weight(1f))

            RedButton(
                text = if (product.added) "Added" else "Add",
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        if (!product.added) {
                            product.added = true
                            addBtnClick(product.id)
                        }
                    },
                isDark = isDarkMode,
                isAdded = product.added
            )
        }
    }
}
