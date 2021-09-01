package com.rushional.nightmare_game.views.gui;

import lombok.Getter;

import java.awt.*;

@Getter
public class ClickCoordinates {
    private final Point pressed;
    private final Point released;

    public ClickCoordinates(Point pressed, Point released) {
        this.pressed = pressed;
        this.released = released;
    }
}