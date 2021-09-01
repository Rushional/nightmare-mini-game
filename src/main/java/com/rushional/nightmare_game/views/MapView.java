package com.rushional.nightmare_game.views;

import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.views.gui.GraphicsCoordinates;
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
    @Getter
    static final int horizontalGap = 5;
    @Getter
    static final int verticalGap = 5;


    public MapView(MapModel mapModel) {
        this.mapModel = mapModel;
        GraphicsCoordinates mapInception = new GraphicsCoordinates(50, 50);
        for (int i = 0; i < 5; i++) {
            GraphicsCoordinates coords = calcShift(i, mapInception);
            RowView rowView = new RowView(mapModel.getRow(i), coords);
            rowViews.add(rowView);
        }
    }

    public RowView getRowView(int i) {
        return rowViews.get(i);
    }

    public SquareView getSquareView(SquareCoordinates coords) {
        return rowViews.get(coords.getRow()).getSquareView(coords.getColumn());
    }

    private GraphicsCoordinates calcShift(int row, GraphicsCoordinates inception) {
        return GraphicsCoordinates.shift(
                inception, 0, row * (MapView.getSquareSidePx() + MapView.getVerticalGap())
        );
    }
}
