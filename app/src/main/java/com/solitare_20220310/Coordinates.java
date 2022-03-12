package com.solitare_20220310;

import android.widget.FrameLayout;

public class Coordinates {
    private FrameLayout gameLayout;
    private CardSize cardSize;
    private static final int COEFFICIENT_X = 130;
    private static final int COEFFICIENT_Y = 180;
    private static final int START_POSITION_X = 20;
    private static final int START_POSITION_Y = 10;

    public Coordinates(FrameLayout gameLayout) {
        this.gameLayout = gameLayout;
    }

    public Coordinates(CardSize cardSize) {
        this.cardSize = cardSize;
    }

    public int getXCoordinate (int column){
        return column* cardSize.getWidth()+START_POSITION_X;
    }

    public int getYCoordinate(int row){
        return row*cardSize.getHeight()+START_POSITION_Y;
    }

}
