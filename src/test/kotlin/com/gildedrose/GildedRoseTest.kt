package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun name() {
        val items = arrayOf<Item>(Item("food", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("food", app.items[0].name)

    }

    @Test
    fun sellInDecrease() {
        val items = arrayOf<Item>(Item("food", 1, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)

    }

    @Test
    fun qualityDecrease() {
        val items = arrayOf<Item>(Item("food", 2, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].quality)

    }

    @Test
    fun passedSellIn() {
        val items = arrayOf<Item>(Item("food", 0, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)

    }

    @Test
    fun negativeQuality() {
        val items = arrayOf<Item>(Item("food", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)

    }

    @Test
    fun agedBrie() {
        val items = arrayOf<Item>(Item("Aged Brie", 2, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].quality)

    }

    @Test
    fun overFifty() {
        val items = arrayOf<Item>(Item("Aged Brie", 1, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)

    }

    @Test
    fun sulfurasSellIn() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 1, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].sellIn)

    }

    @Test
    fun sulfurasQuality() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 0, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(80, app.items[0].quality)

    }

    @Test
    fun backstageTenDays() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 10, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(2, app.items[0].quality)

    }

    @Test
    fun backstageFiveDays() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 5, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(3, app.items[0].quality)

    }

    @Test
    fun backstageZeroDays() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 0, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)

    }

}


