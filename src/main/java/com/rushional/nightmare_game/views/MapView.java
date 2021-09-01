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
    private static final int squareSidePx = 70;
    @Getter
    private static final int horizontalGap = 5;
    @Getter
    private static final int verticalGap = 5;
    @Getter
    private static final GraphicsCoordinates mapInceptionPoint = new GraphicsCoordinates(50, 10);


    public MapView(MapModel mapModel) {
        this.mapModel = mapModel;
        for (int i = 0; i < 5; i++) {
            GraphicsCoordinates shiftedInception = calcShift(i, mapInceptionPoint);
            RowView rowView = new RowView(mapModel.getRow(i), shiftedInception, i);
            rowViews.add(rowView);
        }
    }

    public RowView getRowView(int i) {
        return rowViews.get(i);
    }

    public SquareView getSquareView(SquareCoordinates coords) {
        return rowViews.get(coords.getRow()).getSquareView(coords.getColumn());
    }

    public List<SquareView> getAllSquareViews() {
        ArrayList<SquareView> all = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            RowView currentRow = getRowView(i);
            for (int j = 0; j < 5; j++) {
                all.add(currentRow.getSquareView(j));
            }
        }
        return all;
    }

    private GraphicsCoordinates calcShift(int row, GraphicsCoordinates inception) {
        return GraphicsCoordinates.shift(
                inception, 0, row * (MapView.getSquareSidePx() + MapView.getVerticalGap())
        );
    }
}
