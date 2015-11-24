package domian.cards.impl;


import domian.cards.api.Card;

/**
 * Created by vicboma on 24/11/15.
 */
public class CardImpl implements Card {
    private String palo;
    private String num;

    public static Card Create(String num, String palo){
        return new CardImpl( num,palo);
    }

    public CardImpl(String num, String palo) {
        this.palo = palo;
        this.num = num;
    }

    public String palo() {
        return palo;
    }

    public String num() {
        return num;
    }

}
