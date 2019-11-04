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
            logger.info("==============================");
            logger.info("Début de la journée : ");
            logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
            logger.info("Item : " + items[i].name + " | SellIn : " + items[i].sellIn);

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        if (items[i].name.contains("Conjured")) {
                            items[i].quality = items[i].quality - 2;
                            logger.info("L'item perd 2 de quality");
                            logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                            logger.info("--------------------------------------------------------------");
                        } else {
                            logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                            items[i].quality = items[i].quality - 1;
                            logger.info("L'item perd 1 de quality");
                            logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                            logger.info("--------------------------------------------------------------");
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                    items[i].quality = items[i].quality + 1;
                    logger.info("L'item gagne 1 de quality");
                    logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                    logger.info("--------------------------------------------------------------");

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                                items[i].quality = items[i].quality + 1;
                                logger.info("L'item gagne 1 de quality");
                                logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                                logger.info("--------------------------------------------------------------");
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                                items[i].quality = items[i].quality + 1;
                                logger.info("L'item gagne 1 de quality");
                                logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                                logger.info("--------------------------------------------------------------");
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                logger.info("Item : " + items[i].name + " | SellIn : " + items[i].sellIn);
                items[i].sellIn = items[i].sellIn - 1;
                logger.info("L'item perd 1 de SellIn");
                logger.info("Item : " + items[i].name + " | SellIn : " + items[i].sellIn);
                logger.info("--------------------------------------------------------------");

            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                                items[i].quality = items[i].quality - 1;
                                logger.info("L'item perd 1 de quality");
                                logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                                logger.info("--------------------------------------------------------------");
                            }
                        }
                    } else {
                        logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                        items[i].quality = items[i].quality - items[i].quality;
                        logger.info("L'item perd " + items[i].quality + " de quality");
                        logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                        logger.info("--------------------------------------------------------------");
                    }
                } else {
                    if (items[i].quality < 50) {
                        logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                        items[i].quality = items[i].quality + 1;
                        logger.info("L'item gagne 1 de quality");
                        logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
                        logger.info("--------------------------------------------------------------");
                    }
                }
            }
            logger.info("Fin de la journée : ");
            logger.info("Item : " + items[i].name + " | Quality : " + items[i].quality);
            logger.info("Item : " + items[i].name + " | SellIn : " + items[i].sellIn);
            logger.info("==============================");
        }
    }

    public Item[] getItems() {
        return items;
    }
}