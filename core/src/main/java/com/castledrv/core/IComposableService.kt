package com.castledrv.core

import androidx.compose.runtime.Composable

interface IComposableService<T> {

    val content: @Composable (item: T) -> Unit

    @Suppress("UNCHECKED_CAST")
    @Composable
    fun ComposableItem(item: Any) {
        (item as? T)?.let {
            content(item)
        }
    }
}