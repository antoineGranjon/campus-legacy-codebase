package com.gildedrose;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Logger logger = LoggerFactory.getLogger(GildedRose.class);


        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals("Aged Brie") && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        if (items[i].name.contains("Conjured")) {
                            items[i].quality = items[i].quality - 2;
                        } else {
                            items[i].quality = items[i].quality - 1;
                        }
                    }
                }
                logger.info("If quality > 0 || Item : " + items[i].name + " | Quality : " + items[i].quality);
                logger.info("If quality  > 0  || Item : " + items[i].name + " | SellIn : " + items[i].sellIn);
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
                logger.info("If quality < 50 || Item : " + items[i].name + " | Quality : " + items[i].quality);
                logger.info("If quality < 50 || Item : " + items[i].name + " | SellIn : " + items[i].sellIn);
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            logger.info("If sellIn # sulfuras || Item : " + items[i].name + " | Quality : " + items[i].quality);
            logger.info("If sellIn # sulfuras || Item : " + items[i].name + " | SellIn : " + items[i].sellIn);

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - 2;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
            logger.info("If sellIn <0 || Item : " + items[i].name + " | Quality : " + items[i].quality);
            logger.info("If sellIn <0 || Item : " + items[i].name + " | SellIn : " + items[i].sellIn);
        }
    }

    public Item[] getItems() {
        return items;
    }
}