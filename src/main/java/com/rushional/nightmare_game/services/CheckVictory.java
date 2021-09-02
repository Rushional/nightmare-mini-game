package com.rushional.nightmare_game.services;

import com.rushional.nightmare_game.models.GoalModel;
import com.rushional.nightmare_game.models.MapModel;
import com.rushional.nightmare_game.models.squares.FilledSquare;
import com.rushional.nightmare_game.models.squares.Square;
import com.rushional.nightmare_game.models.squares.SquareColor;

import java.util.List;

public class CheckVictory {
    public static boolean call(MapModel map, GoalModel goal) {
        for (int j = 0; j < 3; j++) {
            SquareColor color = goal.getColor(j);
            int columnIndex = getColumnIndex(j);
            List<Square> column = map.getColumnList(columnIndex);
            for (Square square : column) {
                if (!(square instanceof FilledSquare))
                    return false;
                if (((FilledSquare)square).getColor() != color)
                    return false;
            }
        }
        return true;
    }

    private static int getColumnIndex(int j) {
        switch (j) {
            case 0:
                return 0;
            case 1:
                return 2;
            case 2:
                return 4;
            default:
                throw new RuntimeException();
        }
    }
}
