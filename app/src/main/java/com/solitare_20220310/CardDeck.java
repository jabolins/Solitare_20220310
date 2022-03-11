package com.solitare_20220310;

import android.widget.FrameLayout;

import java.util.ArrayList;

public class CardDeck {

    private FrameLayout gameFl;
    private ArrayList<Card> aces;
    private ArrayList<Card> playCards;

    public CardDeck(FrameLayout gameFl) {
        this.gameFl = gameFl;
        createDeck();
    }

    public ArrayList<Card> getAces() {
        return aces;
    }

    public ArrayList<Card> getPlayCards() {
        return playCards;
    }

    private void createDeck() {
        Card dA = new Card("DA", 1, gameFl.findViewById(R.id.dAbt));
        Card d2 = new Card("D2", 2, gameFl.findViewById(R.id.d2bt));
        Card d3 = new Card("D3", 3, gameFl.findViewById(R.id.d3bt));
        Card d4 = new Card("D4", 4, gameFl.findViewById(R.id.d4bt));
        Card d5 = new Card("D5", 5, gameFl.findViewById(R.id.d5bt));
        Card d6 = new Card("D6", 6, gameFl.findViewById(R.id.d6bt));
        Card d7 = new Card("D7", 7, gameFl.findViewById(R.id.d7bt));
        Card d8 = new Card("D8", 8, gameFl.findViewById(R.id.d8bt));
        Card d9 = new Card("D9", 9, gameFl.findViewById(R.id.d9bt));
        Card d10 = new Card("D10", 10, gameFl.findViewById(R.id.d10bt));
        Card dJ = new Card("DJ", 11, gameFl.findViewById(R.id.dJbt));
        Card dQ = new Card("DQ", 12, gameFl.findViewById(R.id.dQbt));
        Card dK = new Card("DK", 13, gameFl.findViewById(R.id.dKbt));

        Card hA = new Card("HA", 101, gameFl.findViewById(R.id.hAbt));
        Card h2 = new Card("H2", 102, gameFl.findViewById(R.id.h2bt));
        Card h3 = new Card("H3", 103, gameFl.findViewById(R.id.h3bt));
        Card h4 = new Card("H4", 104, gameFl.findViewById(R.id.h4bt));
        Card h5 = new Card("H5", 105, gameFl.findViewById(R.id.h5bt));
        Card h6 = new Card("H6", 106, gameFl.findViewById(R.id.h6bt));
        Card h7 = new Card("H7", 107, gameFl.findViewById(R.id.h7bt));
        Card h8 = new Card("H8", 108, gameFl.findViewById(R.id.h8bt));
        Card h9 = new Card("H9", 109, gameFl.findViewById(R.id.h9bt));
        Card h10 = new Card("H10", 110, gameFl.findViewById(R.id.h10bt));
        Card hJ = new Card("HJ", 111, gameFl.findViewById(R.id.hJbt));
        Card hQ = new Card("HQ", 112, gameFl.findViewById(R.id.hQbt));
        Card hK = new Card("HK", 113, gameFl.findViewById(R.id.hKbt));

        Card sA = new Card("SA", 201, gameFl.findViewById(R.id.sAbt));
        Card s2 = new Card("S2", 202, gameFl.findViewById(R.id.s2bt));
        Card s3 = new Card("S3", 203, gameFl.findViewById(R.id.s3bt));
        Card s4 = new Card("S4", 204, gameFl.findViewById(R.id.s4bt));
        Card s5 = new Card("S5", 205, gameFl.findViewById(R.id.s5bt));
        Card s6 = new Card("S6", 206, gameFl.findViewById(R.id.s6bt));
        Card s7 = new Card("S7", 207, gameFl.findViewById(R.id.s7bt));
        Card s8 = new Card("S8", 208, gameFl.findViewById(R.id.s8bt));
        Card s9 = new Card("S9", 209, gameFl.findViewById(R.id.s9bt));
        Card s10 = new Card("S10", 210, gameFl.findViewById(R.id.s10bt));
        Card sJ = new Card("SJ", 211, gameFl.findViewById(R.id.sJbt));
        Card sQ = new Card("SQ", 212, gameFl.findViewById(R.id.sQbt));
        Card sK = new Card("SK", 213, gameFl.findViewById(R.id.sKbt));

        Card cA = new Card("CA", 301, gameFl.findViewById(R.id.cAbt));
        Card c2 = new Card("C2", 302, gameFl.findViewById(R.id.c2bt));
        Card c3 = new Card("C3", 303, gameFl.findViewById(R.id.c3bt));
        Card c4 = new Card("C4", 304, gameFl.findViewById(R.id.c4bt));
        Card c5 = new Card("C5", 305, gameFl.findViewById(R.id.c5bt));
        Card c6 = new Card("C6", 306, gameFl.findViewById(R.id.c6bt));
        Card c7 = new Card("C7", 307, gameFl.findViewById(R.id.c7bt));
        Card c8 = new Card("C8", 308, gameFl.findViewById(R.id.c8bt));
        Card c9 = new Card("C9", 309, gameFl.findViewById(R.id.c9bt));
        Card c10 = new Card("C10", 310, gameFl.findViewById(R.id.c10bt));
        Card cJ = new Card("CJ", 311, gameFl.findViewById(R.id.cJbt));
        Card cQ = new Card("CQ", 312, gameFl.findViewById(R.id.cQbt));
        Card cK = new Card("CK", 313, gameFl.findViewById(R.id.cKbt));

        aces = new ArrayList<>();
        aces.add(dA);
        aces.add(hA);
        aces.add(sA);
        aces.add(cA);

        playCards = new ArrayList<>();
        playCards.add(d2);
        playCards.add(d3);
        playCards.add(d4);
        playCards.add(d5);
        playCards.add(d6);
        playCards.add(d7);
        playCards.add(d8);
        playCards.add(d9);
        playCards.add(d10);
        playCards.add(dJ);
        playCards.add(dQ);
        playCards.add(dK);

        playCards.add(h2);
        playCards.add(h3);
        playCards.add(h4);
        playCards.add(h5);
        playCards.add(h6);
        playCards.add(h7);
        playCards.add(h8);
        playCards.add(h9);
        playCards.add(h10);
        playCards.add(hJ);
        playCards.add(hQ);
        playCards.add(hK);

        playCards.add(s2);
        playCards.add(s3);
        playCards.add(s4);
        playCards.add(s5);
        playCards.add(s6);
        playCards.add(s7);
        playCards.add(s8);
        playCards.add(s9);
        playCards.add(s10);
        playCards.add(sJ);
        playCards.add(sQ);
        playCards.add(sK);

        playCards.add(c2);
        playCards.add(c3);
        playCards.add(c4);
        playCards.add(c5);
        playCards.add(c6);
        playCards.add(c7);
        playCards.add(c8);
        playCards.add(c9);
        playCards.add(c10);
        playCards.add(cJ);
        playCards.add(cQ);
        playCards.add(cK);

    }
}
