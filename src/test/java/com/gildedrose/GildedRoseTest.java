package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void normal() {
        Item[] items = new Item[]{
                new Item("normal", 10, 10)};
        GildedRose app = new GildedRose(items);
        for (int i = 0; i < 5; i++) {
            app.updateQuality();

        }
//        assertThat(app.items[0].sellIn).isEqualTo(9);
//        assertThat(app.items[0].quality).isEqualTo(9);
    }

    @Test
    void agedBrie() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    void sulfuras() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 80, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(80);
        assertThat(app.items[0].quality).isEqualTo(80);
    }

    @Test
    void backstage() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(12);
    }

    @Test
    void conjured() {
        Item[] items = new Item[]{
                new Item("Conjured thing", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertThat(app.items[0].sellIn).isEqualTo(9);
        assertThat(app.items[0].quality).isEqualTo(8);
    }
}
