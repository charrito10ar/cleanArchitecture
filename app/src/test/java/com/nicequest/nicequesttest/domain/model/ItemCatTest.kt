package com.nicequest.nicequesttest.domain.model

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ItemCatTest {

    private lateinit var itemCat: ItemCat
    @Before
    fun setUp() {
    }

    @Test
    fun getAndSetId() {
        itemCat = ItemCat("IdTest", "", "", 10, 100)
        assertEquals(itemCat.id, "IdTest")
    }

    @Test
    fun getAndSetTitle() {
        itemCat = ItemCat("IdTest", "titleTest", "", 10, 100)
        assertEquals(itemCat.title, "titleTest")
    }

    @Test
    fun getAndSetUrl() {
        itemCat = ItemCat("IdTest", "", "urlTest", 10, 100)
        assertEquals(itemCat.url, "urlTest")
    }

    @Test
    fun getAndSetViews() {
        itemCat = ItemCat("IdTest", "", "", 10, 100)
        assertEquals(itemCat.views, 10)
    }
}