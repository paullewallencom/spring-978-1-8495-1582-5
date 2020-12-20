
package com.packtpub.liverestaurant.domain;

import com.quigley.moose.mapping.provider.annotation.XML;
import com.quigley.moose.mapping.provider.annotation.XMLField;


public enum FoodItemType {
    SNACKS("Snacks"), BEVERAGES("Beverages"), STARTERS("Starters"), MEALS(
            "Meals"), COFFEE("Coffee"), JUICES("Juices"), DESSERTS("Desserts");

    private final String value;

    private FoodItemType(String value) {
        this.value = value;
    }

    public String xmlValue() {
        return value;
    }

    public static FoodItemType convert(String value) {
        for (FoodItemType inst : values()) {
            if (inst.xmlValue().equals(value)) {
                return inst;
            }
        }
        return null;
    }
}
