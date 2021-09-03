package com.rushional.nightmare_game.models;

import com.rushional.nightmare_game.models.squares.SquareColor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoalModel {
    private final List<SquareColor> listColors;

    public GoalModel(boolean isRandom) {
        listColors = getDefaultColorsOrder();
        if (isRandom) Collections.shuffle(listColors);
    }

    private List<SquareColor> getDefaultColorsOrder() {
        List<SquareColor> defaultColors = new ArrayList<>();
        defaultColors.add(SquareColor.GREEN);
        defaultColors.add(SquareColor.BLUE);
        defaultColors.add(SquareColor.RED);
        return defaultColors;
    }

    public SquareColor getColor(int i) {
        return listColors.get(i);
    }
}
