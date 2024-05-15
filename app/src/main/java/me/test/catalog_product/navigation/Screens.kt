package me.test.catalog_product.navigation

import me.test.domain.utils.UiConstant
import me.test.domain.utils.UiConstant.ScreenConst.DETAIL_PRODUCT

sealed class Screens(val route: String) {
    data object Home : Screens(UiConstant.ScreenConst.HOME)
    data object DetailProduct : Screens("$DETAIL_PRODUCT/{id}") {
        fun passId(id: Long?): String {
            return "$DETAIL_PRODUCT/$id"
        }
    }
    data object Search : Screens(UiConstant.ScreenConst.SEARCH)

}