package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {
    private GildedRose app;

    @BeforeEach
    void initializeApp() {
        app = new GildedRose();
    }

    @Test
    void testUpdateQuality_WhenPassingNormalItem_DecreasesSellInAndDecreasesQuality(){
        Item[] items = {new Item("Teddy Bear", 5, 12)};
        app.setItems(items);

        app.updateQuality();

        Item item = app.getItems()[0];
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(11);
    }
    @Test
    void testUpdateQuality_WhenPassingAgedBrie_DecreasesSellInAndIncreasesQuality() {
        Item[] items = {new Item("Aged Brie", 5, 12)};
        app.setItems(items);

        app.updateQuality();

        Item item = app.getItems()[0];
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(13);
    }

    @Test
    void testUpdateQuality_WhenPassingAgedBrieWithMaxQuality_DecreasesSellInAndKeepsQuality() {
        Item[] items = {new Item("Aged Brie", 5, 50)};
        app.setItems(items);

        app.updateQuality();

        Item item = app.getItems()[0];
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    void testUpdateQuality_WhenPassingSulfuras_KeepsSellInAndKeepsQuality() {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", 5, 80)};
        app.setItems(items);

        app.updateQuality();

        Item item = app.getItems()[0];
        assertThat(item.sellIn).isEqualTo(5);
        assertThat(item.quality).isEqualTo(80);
    }

    @Test
    void testUpdateQuality_WhenPassingBackstagePasses_DecreasesSellInAndIncreasesQuality() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 20, 33)};
        app.setItems(items);

        app.updateQuality();

        Item item = app.getItems()[0];
        assertThat(item.sellIn).isEqualTo(19);
        assertThat(item.quality).isEqualTo(34);
    }
    @Test
    void testUpdateQuality_WhenPassingBackstagePassesBetween10and5daysSellIn_DecreasesSellInAndIncreasesQuality() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 32)};
        app.setItems(items);

        app.updateQuality();

        Item item = app.getItems()[0];
        assertThat(item.sellIn).isEqualTo(9);
        assertThat(item.quality).isEqualTo(34);
    }
    @Test
    void testUpdateQuality_WhenPassingBackstagePassesBetween5and0daysSellIn_DecreasesSellInAndIncreasesQuality() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 32)};
        app.setItems(items);

        app.updateQuality();

        Item item = app.getItems()[0];
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(35);
    }
    @Test
    void testUpdateQuality_WhenPassingBackstagePassesBetween5and0daysSellInAndMaxQuality_DecreasesSellInAndKeepsQuality() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48)};
        app.setItems(items);

        app.updateQuality();

        Item item = app.getItems()[0];
        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(50);
    }
    @Test
    void testUpdateQuality_WhenPassingBackstagePasses0DaysSellIn_DecreasesSellInAndSets0Quality() {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 32)};
        app.setItems(items);

        app.updateQuality();

        Item item = app.getItems()[0];
        assertThat(item.sellIn).isEqualTo(-1);
        assertThat(item.quality).isEqualTo(0);
    }
}
