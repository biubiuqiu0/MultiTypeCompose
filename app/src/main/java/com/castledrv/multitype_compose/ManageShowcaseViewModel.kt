package com.castledrv.multitype_compose

import androidx.lifecycle.ViewModel
import com.castledrv.multitype_compose.model.*

class ManageShowcaseViewModel : ViewModel() {
    fun produceItems(): List<IFeedItem> {
        val products = ArrayList<IFeedItem>()
        products.add(
            BannerList(
                list = listOf(
                    Banner(
                        title = "PS5国行光驱版 现货 本地直发",
                        cover = "https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp",
                    ),
                    Banner(
                        title = "PS5国行光驱版 现货 本地直发",
                        cover = "https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp",
                    )
                )
            )
        )
        for (i in 1..100) {
            when {
                i % 5 == 0 -> {
                    products.add(
                        Video(
                            title = "PS5国行光驱版 现货 本地直发",
                            cover = "https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp",
                        )
                    )
                }
                i % 4 == 0 -> {
                    products.add(
                        MultiImage(
                            content = "PS5国行光驱版 现货 本地直发",
                            images = "https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp,https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp,https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp",
                            tag = Tag(
                                userAvatar = "https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp",
                                userName = "ITHome",
                                tagName = "新闻"
                            ),
                            interaction = Interaction(3, 4),
                        )
                    )
                }
                else -> {
                    products.add(
                        Cover(
                            title = "PS5国行光驱版 现货 本地直发",
                            cover = "https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp",
                            tag = Tag(
                                userAvatar = "https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp",
                                userName = "ITHome",
                                tagName = "新闻"
                            ),
                            interaction = Interaction(3, 4),
                        )
                    )
                }
            }
        }
        return products
    }


}