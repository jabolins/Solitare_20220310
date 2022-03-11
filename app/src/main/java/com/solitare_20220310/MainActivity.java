package com.solitare_20220310;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private Button newGameBt;
    private Button shuffleBt;
    private FrameLayout gameLayout;
    ArrayList<ImageButton> acesArray;
    ArrayList<ImageButton> playCardArray;
    Card[][] cardBoard;
    CardDeck cardDeck;

    private View.OnClickListener cardClickListener = view -> moveCard(view);
    private View.OnClickListener newGameListener = view -> newGame();
    private View.OnClickListener shuffleCardsListener = view -> shuffleCards();


    Coordinates coordinates = new Coordinates();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameLayout = findViewById(R.id.gameFl);

        newGameBt = findViewById(R.id.startBt);
        newGameBt.setOnClickListener(newGameListener);
        shuffleBt = findViewById(R.id.shuffleBt);
        shuffleBt.setOnClickListener(shuffleCardsListener);
        cardDeck = new CardDeck(gameLayout);

        ArrayList<Card> aces = cardDeck.getAces();
        ArrayList<Card> playCard = cardDeck.getPlayCards();

        for (int i = 0; i < playCard.size(); i++) {
            playCard.get(i).getImageButton().setOnClickListener(cardClickListener);
        }

        cardBoard = new Card[14][4];

        Collections.shuffle(aces);
        for (int i = 0; i < 4; i++) {
            cardBoard[0][i] = aces.get(i);
            cardBoard[0][i].setShuffled(false);
            // cardBoard[1][i] = nAn.get(i);
            cardBoard[1][i] = null;
        }

        Collections.shuffle(playCard);
        int counter = 0;
        for (int i = 2; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                cardBoard[i][j] = playCard.get(counter);
                counter++;
            }
        }

    }

    private void newGame() {

        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                if (cardBoard[i][j] != null) {
                    cardBoard[i][j].getImageButton().setVisibility(View.VISIBLE);
                    setCoordinates(i, j);
                }
            }
        }
    }

    public void moveCard(View view) {
        //atrodam ievadītās kārts vietu
        int row = 0;
        int column = 0;
        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                if (cardBoard[i][j] != null && cardBoard[i][j].getImageButton() == view) {
                    column = i;
                    row = j;
                }
            }
        }

        // pārbaudām vai var samainīt
        for (int i = 1; i < 14; i++) {
            for (int j = 0; j < 4; j++) {
                if (cardBoard[i][j] == null
                        && cardBoard[i - 1][j] != null
                        && cardBoard[column][row] != null) {

                    if (cardBoard[column][row].getValue() - 1 == cardBoard[i - 1][j].getValue()) {

                        cardBoard[i][j] = cardBoard[column][row];
                        cardBoard[column][row] = null;
                        setCoordinates(i, j);

                        if (!cardBoard[i - 1][j].isShuffled()) {
                            cardBoard[i][j].setShuffled(false);
                        }
                    }
                }
            }
        }
    }

    private void shuffleCards() {
        ArrayList<Card> cardForShuffle = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 4; j++) {

                if (cardBoard[i][j] != null && cardBoard[i][j].isShuffled()) {
                    cardForShuffle.add(cardBoard[i][j]);
                    cardBoard[i][j] = null;
                }
            }
        }

        Collections.shuffle(cardForShuffle);
        boolean isFirstFreePlace = false;
        int counter = 0;
        for (int j= 0; j < 4; j++) {
            for (int i = 0; i< 14; i++) {
                if (isFirstFreePlace) {
                    cardBoard[i][j] = cardForShuffle.get(counter);
                    counter++;
                    setCoordinates(i, j);
                }
                if (cardBoard[i][j] == null) {
                    isFirstFreePlace = true;
                }
            }
            isFirstFreePlace=false;

        }
    }

    private void setCoordinates(int i, int j) {
        cardBoard[i][j].getImageButton().setX(coordinates.getX()[i]);
        cardBoard[i][j].getImageButton().setY(coordinates.getY()[j]);
    }
}