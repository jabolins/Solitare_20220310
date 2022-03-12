package com.solitare_20220310;

import android.widget.FrameLayout;

public class CardSize {
    private FrameLayout gameLayout;
    private int coefficientXY;
    private static final int START_POSITION_X =10;
    private static final int SPACE= 2;
    private int width;
    private int height;

    public CardSize(FrameLayout gameLayout) {
        this.gameLayout = gameLayout;
    }

    public int getWidth() {
        width=(gameLayout.getWidth()- START_POSITION_X)/14- SPACE;
       return width;
    }

    public int getHeight() {
        height= (int) Math.round(width*1.5);
        return height;
    }
}
