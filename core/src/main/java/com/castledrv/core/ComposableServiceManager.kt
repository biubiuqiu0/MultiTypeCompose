package com.castledrv.core

import android.util.Log
import androidx.compose.runtime.Composable
import java.util.*
import kotlin.collections.HashMap
import kotlin.reflect.KClass

inline fun <reified T : Any> registerComposableService(
    model: KClass<T>,
    composable: IComposableService<T>
) {
    ComposableServiceManager.register(model.java.name, composable)
}

@Composable
inline fun <reified T> ComposableItem(item: T) {
    ComposableServiceManager.getComposable(item!!::class.java.name)?.also { service ->
        service.ComposableItem(item)
    } ?: run {
        Log.e("ComposableService", "Error !" + item!!::class.java.name + " not register")
    }
}

object ComposableServiceManager {

    private val composableMap = HashMap<String, IComposableService<*>>()

    fun register(key: String, composable: IComposableService<*>) {
        composableMap[key] = composable
    }

    fun getComposable(key: String): IComposableService<*>? {
        return composableMap[key]
    }

    fun collectServices() {
        ServiceLoader.load(IComposableService::class.java).forEach { service ->
            composableMap[service.type] = service
        }
    }
}