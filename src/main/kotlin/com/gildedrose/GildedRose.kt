package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        val specials = arrayOf<String>("Sulfuras, Hand of Ragnaros", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert")

        for (i in items.indices) {
            var qualityChange = 1

            //Not Sulfaras
            if (items[i].name != specials[0]) {
                items[i].sellIn -= 1

                //Passed SellIn
                if (items[i].sellIn < 0) {
                    qualityChange = 2
                }

                //Aged Brie
                if (items[i].name == specials[1]) {
                    items[i].quality += qualityChange

                //Backstage
                } else if (items[i].name == specials[2]) {

                    //Passed SellIn
                    if (qualityChange == 2) {
                        items[i].quality = 0

                    //Over 10 days
                    } else if (items[i].sellIn > 10) {
                        items[i].quality += 1

                    //Fewer than 10 days
                    } else {
                        items[i].quality += 3 - (items[i].sellIn/5)
                    }

                //All other items
                } else {
                    items[i].quality -= qualityChange
                }

                //Check quality < 0
                if (items[i].quality < 0) {
                    items[i].quality = 0
                }

                //Check quality > 50
                if (items[i].quality > 50) {
                    items[i].quality = 50
                }
            }
        }
    }
}

