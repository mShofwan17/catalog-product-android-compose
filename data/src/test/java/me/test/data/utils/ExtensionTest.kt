package me.test.data.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class ExtensionTest {
    @Test
    fun toUiFavourite(){
        val result = 1.toUiFavourite()
        assertEquals(
            true,
            result
        )
    }

    @Test
    fun toEntityFavourite(){
        val result = false.toEntityFavourite()
        assertEquals(
            0,
            result
        )
    }
}