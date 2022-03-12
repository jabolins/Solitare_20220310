package com.solitare_20220310;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Button newGameBt;
    Button shuffleBt;
    FrameLayout gameLayout;
    ArrayList<Card> aces;
    ArrayList<Card> playCard;
    Card[][] cardBoard;
    CardDeck cardDeck;
    CardSize cardSize;
    private View.OnClickListener cardClickListener = view -> moveCard(view);
    private View.OnClickListener newGameListener = view -> newGame();
    private View.OnClickListener shuffleCardsListener = view -> shuffleCards();


    Coordinates coordinates;

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

    }

    private void newGame() {
        cardBoard = new Card[14][4];
        aces = cardDeck.getAces();
        playCard = cardDeck.getPlayCards();

        Collections.shuffle(aces);
        for (int i = 0; i < 4; i++) {
            cardBoard[0][i] = aces.get(i);
            cardBoard[0][i].setShuffled(false);
            cardBoard[1][i] = null;
        }

        Collections.shuffle(playCard);
        int counter = 0;
        for (int y = 0; y < 4; y++) {
            for (int x = 2; x < 14; x++) {
                cardBoard[x][y] = playCard.get(counter);
                counter++;
            }
        }

        cardSize = new CardSize(gameLayout);
        coordinates = new Coordinates(cardSize);

        for (int x = 0; x < 14; x++) {
            for (int y = 0; y < 4; y++) {
                if (cardBoard[x][y] != null) {
                    View view = cardBoard[x][y].getImageButton();
                    ViewGroup.LayoutParams params = view.getLayoutParams();
                    params.width = cardSize.getWidth();
                    params.height = cardSize.getHeight();
                    view.setLayoutParams(params);
                    view.setX(coordinates.getXCoordinate(x));
                    view.setY(coordinates.getYCoordinate(y));
                    view.setVisibility(View.VISIBLE);
                    view.setOnClickListener(cardClickListener);
                }
            }
        }
    }

    public void moveCard(View view) {
        Card cardForCheck = null;
        int cardRow = 0;
        int cardColumn = 0;
        for (int x = 0; x < 14; x++) {
            for (int y = 0; y < 4; y++) {
                if (cardBoard[x][y] != null
                        && cardBoard[x][y].getImageButton() == view) {
                    cardForCheck = cardBoard[x][y];
                    cardColumn = x;
                    cardRow = y;
                }
            }
        }

        // pārbaudām vai var samainīt
        for (int x = 1; x < 14; x++) { // TODO te var izvilkt ārā metodi
            for (int y = 0; y < 4; y++) {
                if (cardBoard[x][y] == null
                        && cardBoard[x - 1][y] != null
                        && cardForCheck != null
                        && cardForCheck.getValue() - 1 == cardBoard[x - 1][y].getValue()) {
                    cardBoard[x][y] = cardForCheck;
                    cardBoard[cardColumn][cardRow] = null;
                    view.setX(coordinates.getXCoordinate(x));
                    view.setY(coordinates.getYCoordinate(y));
                    markCardsShuffled();
                }
            }
        }
    }

    private void markCardsShuffled() {
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 14; x++) {
                if (cardBoard[x][y] != null
                        && cardBoard[x][y].isShuffled()
                        && cardBoard[x - 1][y] != null
                        && !cardBoard[x - 1][y].isShuffled()
                        && cardBoard[x][y].getValue()-1==cardBoard[x-1][y].getValue()) {
                    cardBoard[x][y].setShuffled(false);
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
        shuffleCardboard(cardForShuffle);
    }

    private void shuffleCardboard(ArrayList<Card> cardForShuffle) {
        boolean isFirstNullFound = false;
        int counter = 0;

        Collections.shuffle(cardForShuffle);
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 14; x++) {
                if (isFirstNullFound) {
                    cardBoard[x][y] = cardForShuffle.get(counter);
                    counter++;
                    cardBoard[x][y].getImageButton().setX(coordinates.getXCoordinate(x));
                    cardBoard[x][y].getImageButton().setY(coordinates.getYCoordinate(y));
                }
                if (cardBoard[x][y] == null) {
                    isFirstNullFound = true;
                }
            }
            isFirstNullFound = false;
        }
    }
}