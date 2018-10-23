package com.example.android.openmensa.ExpandableRListView;

import com.thoughtbot.expandablecheckrecyclerview.models.MultiCheckExpandableGroup;

import java.util.List;

public class MultiCheckCity extends MultiCheckExpandableGroup/*ExpandableGroup<Mensa>*/{

    private String geoTag;

    public MultiCheckCity(String cityName, List<Mensa> items, String geoTag) {
        super(cityName, items);
        this.geoTag = geoTag;
    }

    public String getGeoTag() {
        return geoTag;
    }
}
