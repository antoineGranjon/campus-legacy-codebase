package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void redWine() {
        Item[] items = new Item[] { new Item("Red red Wine", -300, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
        assertThat(app.items[0].sellIn).isEqualTo(-301);
    }

    @Test
    void redWine2() {
        Item[] items = new Item[] { new Item("Red red Wine", 250, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(10);
    }

    @Test
    void redWine3() {
        Item[] items = new Item[] { new Item("Red red Wine", -50, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void noName() {
        Item[] items = new Item[] { new Item("item", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].name).isNotEmpty();
    }

    @Test
    void itemQualityShouldDecreaseByOne() {
        Item[] items = new Item[] { new Item("item", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void itemQualityShouldDecreaseByTwo() {
        Item[] items = new Item[] { new Item("item", -5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    void backstageQualityShouldIncreaseByTwo() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(12);
    }

    @Test
    void backstageQualityShouldIncreaseByThree() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(13);
    }

    @Test
    void backstageQualityShouldBeEqualToZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }

    @Test
    void brieQualityShouldIncreaseByOne() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(6);
    }

    @Test
    void brieQualityShouldIncreaseByTwo() {
        Item[] items = new Item[] { new Item("Aged Brie", -5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(7);
    }

    @Test
    void sulfurasQualityShouldNotDecrease() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(80);
    }

    @Test
    void conjuredItemQualityShouldDecreaseByTwo() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(8);
    }

    @Test
    void conjuredItemQualityShouldDecreaseByFour() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -2, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(6);
    }


    @Test
    void itemQualityShouldNeverBeNegative() {
        Item[] items = new Item[] { new Item("Conjured item", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertThat(app.items[0].quality).isEqualTo(0);
    }
}