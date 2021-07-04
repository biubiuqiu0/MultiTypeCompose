package com.castledrv.multitype_compose.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.castledrv.core.IComposableService
import com.castledrv.multitype_compose.model.MultiImage
import com.castledrv.multitype_compose.ui.base.HomeFeedActionBar
import com.castledrv.multitype_compose.ui.base.HomeFeedHeader
import com.castledrv.multitype_compose.ui.base.NetworkImage
import com.google.auto.service.AutoService

@AutoService(IComposableService::class)
class MultiImageComposable : IComposableService<MultiImage> {

    override val content: @Composable (item: MultiImage) -> Unit = { item ->
        HomeFeedHeader(item.tag)
        MultiImageSection(item = item)
    }
    override val type: String
        get() = MultiImage::class.java.name
}


@Composable
fun MultiImageSection(item: MultiImage) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    ) {
        Text(
            text = item.content,
            fontSize = 14.sp,
            maxLines = 5,
            modifier = Modifier.padding(end = 10.dp)
        )
        Row(
            Modifier
                .requiredHeight(140.dp)
                .padding(top = 10.dp)
                .fillMaxWidth()
        ) {
            item.images.split(",").take(3).forEachIndexed { index, item ->
                NetworkImage(
                    url = item,
                    modifier = Modifier.weight(0.3f),
                )
                if (index != 2) {
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
        //action bar
        HomeFeedActionBar(
            item.interaction.likeNum.toString(),
            item.interaction.replyNum.toString(),
            Modifier
                .padding(top = 10.dp, end = 10.dp)
                .align(Alignment.End)
        )
    }
}
