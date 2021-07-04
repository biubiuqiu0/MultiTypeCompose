package com.castledrv.multitype_compose.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class ProductBean(
    val id: Int,
    val url: String,
    val name: String,
    val price: String,
    val origin: String
) {
    var added by mutableStateOf(false)

}
