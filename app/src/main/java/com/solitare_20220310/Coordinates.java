package com.solitare_20220310;

public class Coordinates {
    public Coordinates() {
        fillInX();
        fillInY();
    }

    private static final int COEFFICIENT_X = 130;
    private static final int COEFFICIENT_Y = 180;
    private static final int START_POSITION_X = 20;
    private static final int START_POSITION_Y = 10;

    private int[] x;
    private int[] y;

    public int[] getX() {
        return x;
    }

    public int[] getY() {
        return y;
    }

    private void fillInX() {
        x = new int[14];
        for (int i = 0; i < x.length; i++) {
            x[i] = i * COEFFICIENT_X + START_POSITION_X;
        }
    }

    private void fillInY() {
        y = new int[4];
        for (int i = 0; i < y.length; i++) {
            y[i] = i * COEFFICIENT_Y + START_POSITION_Y;
        }
    }
}
