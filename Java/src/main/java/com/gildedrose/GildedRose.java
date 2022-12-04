package com.gildedrose;

class GildedRose {
    static String AGED_BRIE_NAME = "Aged Brie";
    static String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
    static String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    static int ITEM_QUALITY_LOWER_BOUND = 0;
    static int ITEM_QUALITY_UPPER_BOUND = 50;

    static int BACKSTAGE_PASSES_DOUBLE_QUALITY_MAX_THRESHOLD = 11;
    static int BACKSTAGE_PASSES_TRIPLE_QUALITY_MAX_THRESHOLD = 6;


    private Item[] items;

    public GildedRose() {
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE_NAME)
                && !item.name.equals(BACKSTAGE_PASSES_NAME)) {
                if (item.quality > ITEM_QUALITY_LOWER_BOUND) {
                    if (!item.name.equals(SULFURAS_NAME)) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < ITEM_QUALITY_UPPER_BOUND) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASSES_NAME)) {
                        if (item.sellIn < BACKSTAGE_PASSES_DOUBLE_QUALITY_MAX_THRESHOLD) {
                            if (item.quality < ITEM_QUALITY_UPPER_BOUND) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < BACKSTAGE_PASSES_TRIPLE_QUALITY_MAX_THRESHOLD) {
                            if (item.quality < ITEM_QUALITY_UPPER_BOUND) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS_NAME)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE_NAME)) {
                    if (!item.name.equals(BACKSTAGE_PASSES_NAME)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS_NAME)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = ITEM_QUALITY_LOWER_BOUND;
                    }
                } else {
                    if (item.quality < ITEM_QUALITY_UPPER_BOUND) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}
