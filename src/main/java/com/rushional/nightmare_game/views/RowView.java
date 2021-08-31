package com.rushional.nightmare_game.views;

import com.rushional.nightmare_game.models.Row;
import lombok.Getter;

import java.util.List;


public class RowView {
    @Getter
    private List<SquareView> squareViewsList;

//    TODO: should have nothing to do with Slots
    public RowView(Row rowModel) {
        for (int i = 0; i < 5; i++) {
            SquareView squareView = new SquareView(rowModel.getSquare(i));
            squareViewsList.add(squareView);
        }
    }
}
