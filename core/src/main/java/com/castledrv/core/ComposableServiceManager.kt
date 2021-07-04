package com.castledrv.core

object ComposableServiceManager {

    private val composableMap = HashMap<String, IComposableService<*>>()

    fun register(key: String, composable: IComposableService<*>) {
        composableMap[key] = composable
    }

    fun getComposable(key: String): IComposableService<*>? {
        return composableMap[key]
    }

    fun init() {

    }

}