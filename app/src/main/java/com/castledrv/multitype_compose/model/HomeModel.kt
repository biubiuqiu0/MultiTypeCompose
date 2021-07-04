package com.castledrv.multitype_compose.model


sealed interface IFeedItem

data class BannerList(val list: List<Banner>) : IFeedItem

data class Banner(
    val title: String,
    val cover: String,
)

data class Video(
    val title: String,
    val cover: String,
) : IFeedItem


data class Cover(
    val title: String,
    val cover: String,
    val tag: Tag,
    val interaction: Interaction,
) : IFeedItem


data class MultiImage(
    val content: String,
    val images: String,
    val tag: Tag,
    val interaction: Interaction,
) : IFeedItem


data class Tag(
    val userAvatar: String,
    val userName: String,
    val tagName: String,
)

data class Interaction(
    val replyNum: Int,
    val likeNum: Int
)






