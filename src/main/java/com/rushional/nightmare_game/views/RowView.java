package com.rushional.nightmare_game.views;

import com.rushional.nightmare_game.models.Row;
import com.rushional.nightmare_game.models.SquareCoordinates;
import com.rushional.nightmare_game.views.gui.GraphicsCoordinates;

import java.util.ArrayList;
import java.util.List;


public class RowView {
    private List<SquareView> squareViewsList;

//    TODO: should have nothing to do with Slots
    public RowView(Row rowModel, GraphicsCoordinates inception, int i) {
        squareViewsList = new ArrayList<>();
        for (int j = 0; j < 5; j++) {
            GraphicsCoordinates shiftedInception = calcShift(j, inception);
            SquareCoordinates coords = new SquareCoordinates(i, j);
            SquareView squareView = new SquareView(rowModel.getSquare(j), coords, shiftedInception);
            squareViewsList.add(squareView);
        }
    }

    public SquareView getSquareView(int i) {
        return squareViewsList.get(i);
    }

    private GraphicsCoordinates calcShift(int col, GraphicsCoordinates inception) {
        return GraphicsCoordinates.shift(
                inception, col * (MapView.getSquareSidePx() + MapView.getHorizontalGap()), 0
        );
    }
}
