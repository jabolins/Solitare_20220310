package com.solitare_20220310;

import android.widget.FrameLayout;
import android.widget.ImageButton;

public class Card {
    private String name;
    private int value;
    private ImageButton imageButton;
    private FrameLayout gameFl;
    private boolean isShuffled;

    public Card(String name, int value, ImageButton imageButton) {
        this.name = name;
        this.value = value;
        this.imageButton = imageButton;
        this.isShuffled = true;
    }

    public void setImageButton(ImageButton imageButton) {
        this.imageButton = imageButton;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public ImageButton getImageButton() {
        return imageButton;
    }

    public boolean isShuffled() { return isShuffled;}

    public void setShuffled(boolean shuffled) {
        isShuffled = shuffled;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", imageButton=" + imageButton +
                ", gameFl=" + gameFl +
                '}';
    }
}
