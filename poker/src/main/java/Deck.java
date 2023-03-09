import java.util.Random;

public class Deck extends Hand {

    Random rand = new Random();  //random # generator

    public Deck() {
        super();
    }

    public void populate() {
        //Create all the cards in the deck to be dealt out
        for (Suit suit : Suit.values()) { //loops over the suits
            for (Rank rank : Rank.values()) {  //inner loop adds the ranks to the current suit
                Card card = new Card(rank, suit);
                this.add(card);
            }
        }
    }

    public void shuffle(){
        for (int i = cards.size() -1; i > 0; i--){

            int randNum = rand.nextInt(i);  //Generate a random index to swap the last card with
            Card randCardSaved = cards.get(randNum); //saving the card from the randomly selected index so we can use that spot
            cards.set(randNum, (cards.get(i))); // setting the random spot with the last card
            cards.set(i, randCardSaved);   //set the saved card in the last spot
        }
    }

    public void deal(Hand[] hands, int perHand){  //dealing to multiple people (hands)
        for (int i = 0; i < perHand; i++){
            for (int j=0; j < hands.length; j++){
                this.dealCard(cards.get(0), hands[j]); //Always gives the top card
            }
        }
    }
}