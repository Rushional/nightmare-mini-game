package com.rushional.nightmare_game.views;

import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.models.SquareCoordinates;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class MapView {
    List<RowView> rowViews = new ArrayList<>();
    @Getter
    MapModel mapModel;
//    TODO: move somewhere better
    @Getter
    static final int squareSidePx = 70;

    public MapView(MapModel mapModel) {
        this.mapModel = mapModel;
        for (int i = 0; i < 5; i++) {
            rowViews.add(new RowView(mapModel.getRow(i)));
        }
    }

    public SquareView getSquareView(SquareCoordinates coords) {
        return rowViews.get(coords.getRow()).getSquareView(coords.getColumn());
    }
}
