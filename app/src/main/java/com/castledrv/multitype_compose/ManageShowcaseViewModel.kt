package com.castledrv.multitype_compose

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.castledrv.multitype_compose.model.ProductBean
import kotlinx.coroutines.launch

class ManageShowcaseViewModel : ViewModel() {

    val shops = listOf("淘宝", "京东", "拼多多")

    private val _products = MutableLiveData<List<ProductBean>>()

    private val _darkModeState = mutableStateOf(false)
    val darkModeState: State<Boolean>
        get() = _darkModeState


    val products: LiveData<List<ProductBean>>
        get() = _products


    init {
        mockProducts()
    }


    private fun mockProducts() {
        viewModelScope.launch {
            _products.value = produceProducts()
        }
    }

    fun switchMode() {
        _darkModeState.value = !_darkModeState.value
    }

    private fun produceProducts(): List<ProductBean> {
        val products = ArrayList<ProductBean>()
        for (i in 0..100) {
            products.add(
                ProductBean(
                    id = i,
                    url = "https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp",
                    name = "PS5国行光驱版 现货 本地直发",
                    price = "￥3899",
                    origin = shops[i % 3]
                ).apply {
                    added = i % 6 == 0
                }
            )
        }
        return products
    }


    fun productAddClick(id: Int) {
        _products.value
    }
}