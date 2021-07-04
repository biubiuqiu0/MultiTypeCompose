package com.castledrv.multitype_compose.ui.showcase

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.castledrv.multitype_compose.ManageShowcaseViewModel
import com.castledrv.multitype_compose.model.ProductBean
import com.castledrv.multitype_compose.ui.theme.ManageShowCaseComposeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch


@ExperimentalUnitApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalComposeApi
@Composable
fun ManageShowcaseScreen() {
    val viewModel: ManageShowcaseViewModel = viewModel()

    val products = viewModel.products.observeAsState()

    val scope = rememberCoroutineScope()

    val addMenuState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    val settingDialogState = remember { mutableStateOf(false) }

    val rtlState = remember { mutableStateOf(false) }

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            if (!viewModel.darkModeState.value) Color.Transparent else Color.Black,
            darkIcons = !viewModel.darkModeState.value
        )
    }
    ManageShowCaseComposeTheme(darkTheme = viewModel.darkModeState.value) {
        CompositionLocalProvider(LocalLayoutDirection provides if (rtlState.value) LayoutDirection.Rtl else LayoutDirection.Ltr) {
            ModalBottomSheetLayout(
                sheetState = addMenuState,
                sheetShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
                sheetContent = {
                    AddMenu { scope.launch { addMenuState.hide() } }
                }
            ) {
                Scaffold(topBar = {
                    TopAppBar(
                        backgroundColor = MaterialTheme.colors.background,
                        contentPadding = PaddingValues(start = 18.dp, end = 18.dp)
                    ) {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.ArrowBack),
                            contentDescription = "back",
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "橱窗列表",
                            fontSize = TextUnit(17f, TextUnitType.Sp),
                            fontWeight = FontWeight(700),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.Settings),
                            contentDescription = "setting",
                            modifier = Modifier
                                .size(24.dp)
                                .clickable {
                                    settingDialogState.value = true
                                }
                        )
                    }
                }) {
                    ProductList(
                        products.value ?: emptyList(),
                        viewModel::productAddClick
                    ) { scope.launch { addMenuState.show() } }
                }
            }

            if (settingDialogState.value) {
                Dialog(onDismissRequest = { settingDialogState.value = false }) {
                    Surface(shape = RoundedCornerShape(8.dp)) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp)
                                .requiredHeight(200.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Row {
                                Text("Dark Mode", modifier = Modifier.width(80.dp))
                                Checkbox(
                                    modifier = Modifier.padding(start = 16.dp),
                                    checked = viewModel.darkModeState.value,
                                    onCheckedChange = {
                                        viewModel.switchMode()
                                        settingDialogState.value = false
                                    })
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Row {
                                Text("RTL Mode", modifier = Modifier.width(80.dp))
                                Checkbox(
                                    modifier = Modifier.padding(start = 16.dp),
                                    checked = rtlState.value,
                                    onCheckedChange = {
                                        rtlState.value = !rtlState.value
                                        settingDialogState.value = false
                                    })
                            }
                        }
                    }
                }
            }
        }
    }
}


@ExperimentalUnitApi
@ExperimentalComposeApi
@Composable
fun ProductList(
    products: List<ProductBean>,
    productClick: (Int) -> Unit,
    addMenuClick: () -> Unit
) {
    val viewModel: ManageShowcaseViewModel = viewModel()

    Column {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight(),
            state = rememberLazyListState()
        ) {
            items(items = products, key = { it.id }) {
                ProductItem(product = it, isDarkMode = viewModel.darkModeState.value, productClick)
            }
        }
        RedButton(
            text = "Add",
            modifier = Modifier
                .height(68.dp)
                .padding(start = 16.dp, top = 12.dp, end = 16.dp, bottom = 12.dp)
                .fillMaxWidth()
                .clickable { addMenuClick() }
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun AddMenu(itemClick: () -> Unit) {
    val viewModel: ManageShowcaseViewModel = viewModel()
    LazyColumn {
        items(viewModel.shops) {
            ListItem(text = { Text(it) },
                icon = {
                    Icon(
                        Icons.Default.Favorite,
                        contentDescription = "Localized description",
                    )
                },
                modifier = Modifier.clickable { itemClick() }
            )
        }
    }
}

@ExperimentalUnitApi
@Preview
@Composable
fun TitleBarPreview() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        contentPadding = PaddingValues(start = 18.dp, end = 18.dp)
    ) {
        Icon(
            painter = rememberVectorPainter(image = Icons.Default.ArrowBack),
            contentDescription = "back",
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "橱窗列表",
            fontSize = TextUnit(17f, TextUnitType.Sp),
            fontWeight = FontWeight(700),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = rememberVectorPainter(image = Icons.Default.Settings),
            contentDescription = "setting",
            modifier = Modifier
                .size(24.dp)
                .clickable {
                }
        )
    }
}


@ExperimentalComposeApi
@ExperimentalUnitApi
@Preview
@Composable
fun ProductPreview() {
    ProductItem(
        ProductBean(
            id = 1,
            url = "https://s.yimg.com/uu/api/res/1.2/npZqSAjccPy8bJGFWCylTA--~B/Zmk9ZmlsbDtoPTQ1MDt3PTY3NTthcHBpZD15dGFjaHlvbg--/https://s.yimg.com/os/creatr-uploaded-images/2021-04/bc131410-a8c6-11eb-bfaf-ac07b6db3386.cf.webp",
            name = "PS5国行光驱版 现货 本地直发",
            price = "￥3899",
            origin = "淘宝"
        ).apply {
                added=false
        }, false,
    ) {}
}