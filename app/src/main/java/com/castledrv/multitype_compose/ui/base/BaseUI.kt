package com.castledrv.multitype_compose.ui.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.castledrv.multitype_compose.R
import com.castledrv.multitype_compose.model.Tag
import com.google.accompanist.glide.rememberGlidePainter


@Composable
fun NetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop) {
    Image(
        painter = rememberGlidePainter(
            url,
            fadeIn = true
        ),
        contentDescription = "",
        modifier = modifier,
        contentScale = contentScale
    )
}

@Composable
fun HomeFeedActionBar(like: String, comment: String, modifier: Modifier) {
    Row(modifier = modifier) {
        HomeActionItem(
            painter = painterResource(id = R.mipmap.article_btn_bottom_assist_normal),
            desc = like
        )
        HomeActionItem(
            painter = painterResource(id = R.mipmap.article_btn_bottom_comment),
            desc = comment,
            modifier = Modifier.padding(start = 20.dp)
        )
    }
}

@Composable
fun HomeActionItem(painter: Painter, desc: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painter, "", modifier = Modifier.size(18.dp))
        Text(
            text = desc,
            modifier = Modifier.padding(start = 6.dp),
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun HomeFeedHeader(item: Tag) {
    Row {
        NetworkImage(
            url = item.userAvatar,
            modifier = Modifier
                .requiredSize(20.dp, 20.dp)
                .clip(shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = item.userName, fontSize = 12.sp)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "3天前", fontSize = 12.sp)
        Spacer(modifier = Modifier.weight(1f, true))
        Text(text = item.tagName + "┃", fontSize = 12.sp, color =  Color(0xff29baca))
    }
}