package com.rushional.nightmare_game.views;

import com.rushional.nightmare_game.models.MapModel;

import java.util.ArrayList;
import java.util.List;

public class MapView {
    List<RowView> rowViews = new ArrayList<>();
    MapModel mapModel;
//    TODO: move somewhere better
    static final int squareSidePx = 70;

    public MapView(MapModel mapModel) {
        this.mapModel = mapModel;
        for (int i = 0; i < 5; i++) {
            rowViews.add(new RowView(mapModel.getRow(i)));
        }
    }
}
