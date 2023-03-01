/*
hand class: parent class of the deck class
 */

import java.util.ArrayList;

public class Hand {
    protected ArrayList<Card> cards;


    public Hand() {
        //Each hand starts off with 0 cards, and the cards need be dealt from the deck
        this.cards = new ArrayList<Card>();
    }



    public void add(Card card) {
        cards.add(card);
    }


    public String showHand() {
        String str = "";
        for (Card c : cards) {
            str += c.toString() + "\n";
        }
        return str;
    }


    public boolean dealCard(Card card, Hand otherHand) {
        if (!cards.contains(card)) {
            //Make sure that the same card isn't dealt twice
            return false;
        } else {
            cards.remove(card); //This removes the card dealt from the top of the deck (it has been dealt and therefore
            //no longer the top of the deck// )

            otherHand.add(card); //Deals the next card
            return true;

        }
    }
}




