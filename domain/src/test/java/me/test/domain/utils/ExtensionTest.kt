package me.test.domain.utils

import org.junit.Test
import org.junit.Assert.assertEquals

class ExtensionTest {
    @Test
    fun toIdrCurrency(){
        val price = 100000
        assertEquals(
            "Rp100.000",
            price.toDouble().toIdrCurrency()
        )
    }
}