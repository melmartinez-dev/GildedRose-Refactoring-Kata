package com.gildedrose;

class GildedRose {
    final static String AGED_BRIE_NAME = "Aged Brie";
    final static String BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
    final static String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    final static int ITEM_QUALITY_LOWER_BOUND = 0;
    final static int ITEM_QUALITY_UPPER_BOUND = 50;
    final static int BACKSTAGE_PASSES_DOUBLE_QUALITY_MAX_THRESHOLD = 11;
    final static int BACKSTAGE_PASSES_TRIPLE_QUALITY_MAX_THRESHOLD = 6;


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

    private void updateQualityAgedBrie(Item item) {
        if (item.quality < ITEM_QUALITY_UPPER_BOUND) item.quality++;
        item.sellIn--;
    }

    private void updateQualitySimpleItem(Item item) {
        if (item.quality > ITEM_QUALITY_LOWER_BOUND) item.quality--;
        item.sellIn--;
    }

    private void updateQualityBackstagePasses(Item item) {
        if (item.quality < ITEM_QUALITY_UPPER_BOUND) item.quality++;
        if (item.quality < ITEM_QUALITY_UPPER_BOUND && item.sellIn < BACKSTAGE_PASSES_DOUBLE_QUALITY_MAX_THRESHOLD)
            item.quality++;
        if (item.quality < ITEM_QUALITY_UPPER_BOUND && item.sellIn < BACKSTAGE_PASSES_TRIPLE_QUALITY_MAX_THRESHOLD)
            item.quality++;
        if (item.sellIn == 0) item.quality = ITEM_QUALITY_LOWER_BOUND;
        item.sellIn--;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE_NAME:
                    updateQualityAgedBrie(item);
                    break;
                case BACKSTAGE_PASSES_NAME:
                    updateQualityBackstagePasses(item);
                    break;
                case SULFURAS_NAME:
                    break;
                default:
                    updateQualitySimpleItem(item);
            }
        }
    }
}
